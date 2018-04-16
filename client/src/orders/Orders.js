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
        fetch('/api/invoices/', {
            headers : { 
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(results => {
            return results.json();
        })
        .then(data => {
            console.log(data);
            const posts = data;
            this.setState({
                posts,
            });
        })
    }

    renderWaitingOrders(posts) {
        const po = posts.map((post) => {
            let order = null;
            if(post.invoiceStatus == 1) {
                order = <Order
                key={post.id}
                post={post}
            />
            }
            return order;
        })
        return po;
    }

    renderRejectedOrders(posts) {
        const po = posts.map((post) => {
            let order = null;
            if(post.invoiceStatus == 0) {
                order = <Order
                key={post.id}
                post={post}
            />
            }
            return order;
        })
        return po;
    }

    renderDoneOrders(posts) {
        const po = posts.map((post) => {
            let order = null;
            if(post.invoiceStatus == 2) {
                order = <Order
                key={post.id}
                post={post}
            />
            }
            return order;
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
                    {this.renderWaitingOrders(this.state.posts)}
                </div>
                <div className="orders-rejected">
                    <PageHeader>
                        <small>Orders That Are Rejected</small>
                    </PageHeader>
                    {this.renderRejectedOrders(this.state.posts)}
                </div>
                <div className="orders-done">
                    <PageHeader>
                        <small>Finished Orders</small>
                    </PageHeader>
                    {this.renderDoneOrders(this.state.posts)}
                </div>
            </div>
        )
    }
}

export default Orders;