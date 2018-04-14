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
            // console.log(results.json())
            return results.json();
        })
        .then(data => {
            var posts = data.results.map((post) => {
                return(
                    <div key={post.results}>
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