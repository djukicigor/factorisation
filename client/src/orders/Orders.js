import React, { Component } from 'react';
import { PageHeader } from 'react-bootstrap';
import Order from './Order.js';
import './orders.css';

class Orders extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
        }

    };

    componentWillMount() {
        fetch('/api/businessYears', {
            headers : { 
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(results => {
            return results.json();
        })
        .then(data => {
            data = [{"id":1,"invoiceNumber":"1","invoiceDate":"12-12-2018","valueDate":null,"base":100.0,"totalPDV":20.0,"paymentAmount":120.0,"invoiceStatus":"da","company":{"id":1,"name":"Telsat","address":"Servo Mihalja 10","pib":"123456789","number":"021468630","email":"telsat.doo@gmail.com","logo":"logo","city":{"id":5,"name":"Požarevac","postalCode":"12000"}},"businessYear":{"id":1,"year":2014,"closed":true},"businessPartner":{"id":1,"name":"Ime","address":"adresa","type":"t","company":{"id":1,"name":"Telsat","address":"Servo Mihalja 10","pib":"123456789","number":"021468630","email":"telsat.doo@gmail.com","logo":"logo","city":{"id":5,"name":"Požarevac","postalCode":"12000"}},"city":{"id":5,"name":"Požarevac","postalCode":"12000"}}}];
            const posts = data;
            this.setState({
                posts,
            });
        })
    }

    renderOrders(posts) {
        const po = posts.map((post) => {
            return( 
                <Order
                    key={post.id}
                    post={post}
                />
            );
        })
        return po;
    }

    render() {
        return (
            <div className="orders-list container">
                <div className="orders-waiting">
                    <PageHeader>
                        <small>Orders Waiting to be Invoiced</small>
                    </PageHeader>
                    {this.renderOrders(this.state.posts)}
                </div>
            </div>
        )
    }
}

export default Orders;