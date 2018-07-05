import React from 'react';
import { Link } from 'react-router-dom';
import { Navbar, Nav, NavItem, Glyphicon } from 'react-bootstrap';
import './header.css';

const Header = () => {
    const id = parseInt(sessionStorage.getItem('id'));
    const pricelist = (sessionStorage.getItem('type') === 'company') ? (<Link style={{display: 'none'}} to={'/pricelist/' + id}>Price List</Link>) : (<Link to='/companies'>Companies</Link>);
    const goods = (sessionStorage.getItem('type') === 'company') ? (<NavItem eventKey={3}> <Link to={'/goods/' + id}>Goods</Link> </NavItem> ): "";
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
                    <Link to='/orders'>Orders</Link>
                </NavItem>
                {goods}
            </Nav>
            <Link className="current" to='/logout'><Glyphicon glyph="log-out" /> Log Out</Link>
        </Navbar>
    </header>
    )
};

export default Header;