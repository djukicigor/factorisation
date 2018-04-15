import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Home from '../home/Home';
import Cities from '../cities/Cities.js';
import PriceList from '../priceList/PriceList.js';
import Goods from '../goods/Goods.js';
import Orders from '../orders/Orders.js';
import LogIn from '../logIn/LogIn.js';
import LogOut from '../logOut/LogOut.js';

const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={Home}/>
      <Route path='/cities' component={Cities}/>
      <Route path='/pricelist' component={PriceList}/>
      <Route path='/goods' component={Goods}/>
      <Route path='/orders' component={Orders}/>
      <Route path='/login' component={LogIn}/>
      <Route path='/logout' component={LogOut}/>
    </Switch>
  </main>
)

export default Main;