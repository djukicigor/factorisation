import React from 'react';
import { Link } from 'react-router-dom';
import { Navbar, Nav, NavItem, Glyphicon } from 'react-bootstrap';
import './header.css';
// console.log(sessionStorage.getItem('user'));

const Header = () => {
    const id = parseInt(sessionStorage.getItem('id'));
    const pricelist = (sessionStorage.getItem('type') == 'company') ? (<Link to='/companies'>Companies</Link>) : (<Link to={'/pricelist/' + id}>Price List</Link>)
    return (
    <header>
        <Navbar>
            <Navbar.Header>
                <Navbar.Brand>
                    <Link to='/'>Factorisation <Glyphicon glyph="home" /></Link>
                </Navbar.Brand>
            </Navbar.Header>
            <Nav>
                <NavItem eventKey={1}>
                    {pricelist}
                </NavItem>
                <NavItem eventKey={2}>
                    <Link to='/goods'>Goods</Link>
                </NavItem>
                <NavItem eventKey={3}>
                    <Link to='/orders'>Orders</Link>
                </NavItem>
            </Nav>
            <Link className="current" to='/logout'><Glyphicon glyph="log-out" /> Log Out</Link>
        </Navbar>
    </header>
    )
};

export default Header;