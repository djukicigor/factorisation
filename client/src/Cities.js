import React, { Component } from 'react';

export class Cities extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
        }
    };

    componentDidMount() {
        fetch('/api/businessYears/getBusinessYears', {
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
            var posts = data.map((post) => {
                return(
                    <div key={post.id}>
                        <p> {post.year} </p>
                    </div>
                )
            })
            
            this.setState({posts: posts});
            console.log("state", this.state.posts); 
        })
    }

    render() {
        return (
            <div>
                 {this.state.posts}
            </div>
        )
    }
}