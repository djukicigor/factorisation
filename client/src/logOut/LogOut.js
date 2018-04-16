import React, { Component } from 'react';
import { Well, PageHeader, Form ,FormGroup ,FormControl ,Col ,ControlLabel ,Button } from 'react-bootstrap';
import { Redirect } from 'react-router-dom';

class LogIn extends Component {
    constructor() {
        super();
        sessionStorage.setItem('user', 'loggedOut');
    };

    submitLogin() {
        sessionStorage.setItem('user', 'name');
        console.log(sessionStorage.getItem('user'));
    }

    render() {
        return <Redirect to='/'/>;
    }
}

export default LogIn;