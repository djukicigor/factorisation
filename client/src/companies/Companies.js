import React, { Component } from 'react';
import { PageHeader } from 'react-bootstrap';
import Company from './Company.js';
import './companies.css';

class Companies extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
        }
    };

    componentWillMount() {
        fetch('/api/companies/', {
            headers : { 
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(results => {
            return results.json();
        })
        .then(data => {
            // console.log(data);
            const posts = data;
            this.setState({
                posts,
            });
        })
    }

    renderCompanies(posts) {
        const po = posts.map((post) => {
            return( 
                <Company
                    key={post.id}
                    post={post}
                />
            );
        })
        return po;
    }

    render() {
        return (
            <div className="companies-list container">
                <PageHeader>
                    <small>Companies</small>
                </PageHeader>
                {this.renderCompanies(this.state.posts)}
            </div>
        )
    }
}

export default Companies;