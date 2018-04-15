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
    };

    handleChange(event, name) {
        const checkboxes = this.state.checkboxes;
        checkboxes[name] = !checkboxes[name];
        this.setState({
            disabled: false,
            checkboxes,
        })
    }

    componentWillMount() {
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
            data = [{"id":1,"naziv":"stolica","mera":"kom"},{"id":2,"naziv":"brasno","mera":"kg"},{"id":3,"naziv":"sto","mera":"kom"}]
            const posts = data;
            this.setState({
                posts,
            });
        })
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
                />
            );
        })
        return po;
    }

    render() {
        return (
            <div className="price-list">
                <Table striped bordered condensed hover>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Unit</th>
                            <th>Add to Price List</th>
                        </tr>
                    </thead>
                    <tbody>  
                        {this.renderGoods(this.state.posts)}
                        <tr>
                            <td colSpan="3">
                                <p></p>
                            </td>
                            <td className="submit-td">
                                <Button type="submit" disabled>Add to cart</Button>
                            </td>
                        </tr>
                    </tbody>
                </Table>
            </div>
        )
    }
}

export default Goods;