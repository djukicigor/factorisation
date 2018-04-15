import React from 'react';
import { Link } from 'react-router-dom';
import { Navbar, Nav, NavItem, Glyphicon } from 'react-bootstrap';
import './header.css';

const Header = () => {
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
                    <Link to='/pricelist'>Price List</Link>
                </NavItem>
                <NavItem eventKey={2}>
                    <Link to='/goods'>Goods</Link>
                </NavItem>
                <NavItem eventKey={3}>
                    <Link to='/orders'>Orders</Link>
                </NavItem>
                <NavItem eventKey={4}>
                    <Link to='/cities'>Cities</Link>
                </NavItem>
            </Nav>
            <Link className="current" to='/logout'><Glyphicon glyph="log-out" /> Log Out</Link>
        </Navbar>
    </header>
    )
};

export default Header;

{/* <li>
                    <Link to='/pricelist'>Price List</Link>
                </li>
                <li>
                    <Link to='/goods'>Goods</Link>
                </li>
                <li>
                    <Link to='/orders'>Orders</Link>
                </li>
                <li>
                    <Link to='/cities'>Cities</Link>
                </li> */}