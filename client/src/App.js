import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {Cities} from './Cities.js';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Cities />
      </div>
    );
  }
}

export default App;
