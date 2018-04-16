import React, { Component } from 'react';
import { Table, Button } from 'react-bootstrap';
import './goods.css';
import Good from './Good.js';

class Goods extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
            disabled: true,
            checked: false,
            checkboxes: {}
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleTextChange = this.handleTextChange.bind(this);
    };

    handleChange(event, name) {
        const checkboxes = this.state.checkboxes;
        checkboxes[name] = !checkboxes[name];
        this.setState({
            disabled: false,
            checkboxes,
        })
    }

    handleTextChange(event) {
        const el = event.target.value;
        if (el.length > 0) { 
            this.setState({ disableButton: false })
        }
    }

    componentWillMount() {
        fetch('/api/goodsorservices/', {
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

    addToPriceLIst() {
        let json = {
            "id": 4,
            "price": 100,
            "pricelistId": 1,
            "goodsOrServices": 3
        };
        fetch('/api/pricelistitems', {
            method: 'POST',
            headers : { 
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(json)
        }).then(function(response) {
            return response.json();
        }).then(function(data) {
            console.log(data);
        });
    }

    renderGoods(posts) {
        const checkboxes = this.state.checkboxes;
        const po = posts.map((post) => {
            if (!checkboxes[`check-${post.id}`]) {
                checkboxes[`check-${post.id}`] = false;
            }
            return( 
                <Good
                    key={post.id}
                    post={post}
                    changeCallback={this.handleChange}
                    checked={checkboxes[`check-${post.id}`]}
                    changeTextCallback={this.handleTextChange}
                />
            );
        })
        return po;
    }

    render() {
        return (
            <div className="goods-list">
                <Table striped bordered condensed hover>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Unit</th>
                            <th>Price</th>
                            <th>Add to Price List</th>
                        </tr>
                    </thead>
                    <tbody>  
                        {this.renderGoods(this.state.posts)}
                        <tr>
                            <td colSpan="4">
                                <p></p>
                            </td>
                            <td className="submit-td">
                                <Button type="submit" disabled={this.state.disableButton} onClick={this.addToPriceLIst} >Add to Price List</Button>
                            </td>
                        </tr>
                    </tbody>
                </Table>
            </div>
        )
    }
}

export default Goods;