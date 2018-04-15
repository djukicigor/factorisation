import React from 'react';
import { Link } from 'react-router-dom'
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
                <NavItem/>
                <li>
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
                </li>
            </Nav>
            <Link className="current" to='/logout'><Glyphicon glyph="log-out" /> Log Out</Link>
        </Navbar>
    </header>
    )
};

export default Header;