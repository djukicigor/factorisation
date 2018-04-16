import React, { Component } from 'react';
import Header from '../header/Header.js';
import { Redirect } from 'react-router-dom';
import Main from '../main/Main.js';
import './App.css';

class App extends Component {
  render() {
    if (!sessionStorage.getItem('user') || sessionStorage.getItem('user') === 'loggedOut') {
      return (
        <div className="App">
          <Redirect to='/login' />
          <Main />
        </div>
      );
    }

    if (sessionStorage.getItem('user') != null) {
      return (
        <div className="App">
          <Header />
          <Main />
        </div>
      );
    }
  }
}

export default App;
