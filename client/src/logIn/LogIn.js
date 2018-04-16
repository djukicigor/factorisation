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
            checked: false
        }

        this.submitLogin = this.submitLogin.bind(this);
        this.changeType = this.changeType.bind(this);
    };

    handleUsernameChange(e) {
        this.setState({username: e.target.value});
    };

    handlePasswordChange(e) {
        this.setState({password: e.target.value});
    };

    changeType() {
        this.state.checked = !this.state.checked;
        console.log(this.state.checked)
    }
    
    submitLogin(e) {
        let self = this;
        e.preventDefault();
        let username = this.state.username;
        let password = this.state.password;
        let checked = this.state.checked;

        console.log(checked)

        let parseJson = {
            "username": username,
            "password": password
        }
        let url = '/api/businesspartners/login';
        fetch(url, {
            method: 'POST',
            headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(parseJson)
        }).then(function(response) {
            return response.json();
        }).then(function(data) {
            // sessionStorage.setItem('id', data.id);
            // sessionStorage.setItem('user', data.name);
            // sessionStorage.setItem('type', 'company');
            self.setState({
                disableButton: true,
                buttonBlocked: true,
                submitText: "Added to Price List",
                redirect: true
            })
        });
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
                                    checked={this.state.selectedOption === 'option1'} 
                                    onChange={this.handleOptionChange} >
                                    Business Partner
                                </Radio>{' '}
                                <Radio 
                                    name="radioGroup" 
                                    inline
                                    checked={this.state.selectedOption === 'option1'} 
                                    onChange={this.handleOptionChange} >
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