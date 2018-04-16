import React, { Component } from 'react';
import { PageHeader } from 'react-bootstrap';
import InvoiceContent from './InvoiceContent.js';
import './invoice.css';

class Invoice extends Component {
    constructor() {
        super();
        this.state = {
            post: {},
            buttonsState: false
        }

        this.invoiceForwarded = this.invoiceForwarded.bind(this);
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

    invoiceForwarded(event, post, type) {
        console.log("doso/" + post.id +"/" +type);
        this.setState({buttonsState: true});
        let id = parseInt(post.id);
        let parseJson = {
            "id": id,
	        "invoiceStatus": parseInt(type)
        }
        fetch('/api/invoices/' + id, {
            method: 'PUT',
            headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(parseJson)
        }).then(function(response) {
            return response.json();
        }).then(function(data) {
            console.log(data);
        });

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
                    buttonsState={this.state.buttonsState}
                    invoiceForward={this.invoiceForwarded}
                />
            </div>
        )
    }
}

export default Invoice;