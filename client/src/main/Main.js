import React, { Component } from 'react';
import { Switch, Route, BrowserRouter as Router } from 'react-router-dom';
import Home from '../home/Home';
import Companies from '../companies/Companies.js';
import PriceList from '../priceList/PriceList.js';
import Goods from '../goods/Goods.js';
import Orders from '../orders/Orders.js';
import Invoice from '../invoice/Invoice.js';
import LogIn from '../logIn/LogIn.js';
import LogOut from '../logOut/LogOut.js';

class Main extends Component {
  constructor() {
      super();
  };

  render() {
    return (
      <Switch>
        <Route exact path='/' component={Home}/>
        <Route path='/companies' component={Companies}/>
        <Route path='/pricelist/:id' component={PriceList}/>
        <Route path='/goods/:id' component={Goods}/>
        <Route path='/orders' component={Orders}/>
        <Route path='/invoice/:id' component={Invoice}/>
        <Route path='/login' component={LogIn}/>
        <Route path='/logout' component={LogOut}/>
      </Switch>
    )
  }
}

export default Main;