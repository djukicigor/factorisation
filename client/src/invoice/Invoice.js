import React, { Component } from 'react';
import { PageHeader } from 'react-bootstrap';
import InvoiceContent from './InvoiceContent.js';
import './invoice.css';

class Invoice extends Component {
    constructor() {
        super();
        this.state = {
            post: {},
        }
    };

    componentWillMount() {
        const invoiceUrl = '/api/invoices/' + this.props.match.params.id;
        fetch(invoiceUrl, {
            headers : { 
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(results => {
            return results.json();
        })
        .then(data => {
            const post = data;
            this.setState({
                post,
            });
        })
    }

    render() {
        return (
            <div className="invoice-div container">
                <PageHeader>
                    <small>Invoice #{this.state.post.id}</small>
                </PageHeader>
                <InvoiceContent
                    key={this.state.post.id}
                    post={this.state.post}
                />
            </div>
        )
    }
}

export default Invoice;