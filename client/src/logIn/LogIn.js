import React, { Component } from 'react';
import { Well, PageHeader, Form ,FormGroup ,FormControl ,Col ,ControlLabel ,Button } from 'react-bootstrap';
import { Redirect } from 'react-router-dom';
import './logIn.css';

class LogIn extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
            redirect: false
        }

        this.submitLogin = this.submitLogin.bind(this);
    };

    submitLogin() {
        // let parseJson = {
        //     "id": Math.round( Math.random() * 10000),
        //     "price": element.price,
        //     "pricelistId": 1,
        //     "goodsOrServicesId": element.id
        // }
        // fetch('/api/pricelistitems', {
        //     method: 'POST',
        //     headers : {
        //         'Content-Type': 'application/json',
        //         'Accept': 'application/json'
        //     },
        //     body: JSON.stringify(parseJson)
        // }).then(function(response) {
        //     return response.json();
        // }).then(function(data) {
        //     self.setState({
        //         disableButton: true,
        //         buttonBlocked: true,
        //         submitText: "Added to Price List",
        //     })
        // });
        this.setState({
            redirect: true
        });
        sessionStorage.setItem('user', 'name');
        console.log(sessionStorage.getItem('user'));
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
                    <Form horizontal>
                        <FormGroup controlId="formHorizontalEmail">
                            <Col componentClass={ControlLabel} sm={2}>
                            Email
                            </Col>
                            <Col sm={10}>
                            <FormControl type="email" placeholder="Email" />
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="formHorizontalPassword">
                            <Col componentClass={ControlLabel} sm={2}>
                            Password
                            </Col>
                            <Col sm={10}>
                            <FormControl type="password" placeholder="Password" />
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