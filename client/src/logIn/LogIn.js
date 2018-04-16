import React, { Component } from 'react';
import { Well, PageHeader, Form ,FormGroup ,FormControl ,Col ,ControlLabel ,Button, Radio } from 'react-bootstrap';
import { Redirect } from 'react-router-dom';
import './logIn.css';

class LogIn extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
            redirect: false,
            username:"",
            password:"",
            selectedOption: '' 
        }

        this.submitLogin = this.submitLogin.bind(this);
    };

    handleUsernameChange(e) {
        this.setState({username: e.target.value});
    };

    handlePasswordChange(e) {
        this.setState({password: e.target.value});
    };
    
    handleOnChange(e) {
        this.setState({ selectedOption: e.target.value});
    }
    
    submitLogin(e) {
        let self = this;
        e.preventDefault();
        let username = this.state.username;
        let password = this.state.password;
        let type = this.state.selectedOption;
        let data ={id:0,}


        let parseJson = {
            "username": username,
            "password": password
        }
        if(username != "" || password != ""){
            let url = (type == 'company') ? '/api/companies/login' : '/api/businesspartners/login';
            fetch(url, {
                method: 'POST',
                headers : {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(parseJson)
            }).then(function(response) {
                if (!response.ok) {
                    throw Error(response.statusText);
                }
                console.log(response)
                return response;
            }).then(function(response) {
                    console.log("ok");
                    return response.json();
                }).catch(function(error) {
                    console.log(error);
            }).then(function(data) {
                if(data){
                    sessionStorage.setItem('id', data.id);
                    sessionStorage.setItem('user', data.name);
                    sessionStorage.setItem('type', 'company');
                    self.setState({
                        redirect: true
                    })
                }
                else{
                    alert("wrong login");
                }
            });
        }
        else{
            alert("Username Or Password Empty")
        }
    }

    render() {
        if (this.state.redirect) {
            return <Redirect to='/'/>;
        }

        return (
            <div className="login">
                <Well>
                    <PageHeader>
                        Log In Page
                    </PageHeader>
                    <Form onSubmit={this.submitLogin.bind(this)} horizontal>
                        <FormGroup controlId="formHorizontalEmail">
                            <Col componentClass={ControlLabel} sm={2}>
                            Username
                            </Col>
                            <Col sm={10}>
                            <FormControl 
                                type="text" 
                                placeholder="Username" 
                                value={this.state.username} 
                                onChange={this.handleUsernameChange.bind(this)} />
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="formHorizontalPassword">
                            <Col componentClass={ControlLabel} sm={2}>
                            Password
                            </Col>
                            <Col sm={10}>
                            <FormControl 
                                type="password" 
                                placeholder="Password" 
                                value={this.state.password} 
                                onChange={this.handlePasswordChange.bind(this)}/>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col sm={12}>
                            <FormGroup>
                                <Radio 
                                    name="radioGroup" 
                                    inline
                                    value="business"
                                    onChange={(e) => this.handleOnChange(e)}
                                    selected={this.state.selectedOption} >
                                    Business Partner
                                </Radio>{' '}
                                <Radio 
                                    name="radioGroup" 
                                    value="company"
                                    inline
                                    onChange={(e) => this.handleOnChange(e)}
                                    selected={this.state.selectedOption} >
                                    Company
                                </Radio>{' '}
                            </FormGroup>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col sm={12}>
                                <Button type="button" onClick={this.submitLogin}>
                                    Sign in
                                </Button>
                            </Col>
                        </FormGroup>
                    </Form>
                </Well>
            </div>
        )
    }
}

export default LogIn;

//  handleClick() {
//     console.log('submitted option', this.state.selectedOption);
//   }

//   handleOnChange(e) {
//     console.log('selected option', e.target.value);
//     this.setState({ selectedOption: e.target.value});
//   }

//   render() {
//     return (
//       <div className="poll">
//         {this.props.model.question}
//         <PollOption
//           options={this.props.model.choices}
//           onChange={(e) => this.handleOnChange(e)}
//           selected={this.state.selectedOption} />
//         <button onClick={() => this.handleClick()}>Vote!</button>
//       </div>
//     );
//   }