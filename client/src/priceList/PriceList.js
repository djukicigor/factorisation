import React, { Component } from 'react';
import { Table, Checkbox, FormControl, Button } from 'react-bootstrap';
import PriceItem from './PriceItem.js';
import './priceList.css';

class PriceList extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
            checkboxes: {},
            disableButton: true
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleTextChange = this.handleTextChange.bind(this);
    };

    handleChange(event, name) {
        const checkboxes = this.state.checkboxes;
        checkboxes[name] = !checkboxes[name];
        this.setState({
            checkboxes,
        })
    }

    handleTextChange(event) {
        const el = event.target.value;
        if (el.length > 0) { 
            this.setState({ disableButton: false })
        }
    }

    componentDidMount() {
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
            const posts = data;
            this.setState({
                posts,
            }); 
        })
    }

    renderPriceList(posts) {
        const checkboxes = this.state.checkboxes;
        const po = posts.map((post) => {
            if (!checkboxes[`check-${post.id}`]) {
                checkboxes[`check-${post.id}`] = false;
            }
            return( 
                <PriceItem
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
            <div className="price-list">
                <Table striped bordered condensed hover>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Unit</th>
                            <th>Ammunt</th>
                            <th>Add to Cart</th>
                        </tr>
                    </thead>
                    <tbody> 
                        {this.renderPriceList(this.state.posts)}
                        <tr>
                            <td colSpan="4">
                                <p></p>
                            </td>
                            <td className="submit-td">
                                <Button type="submit" disabled={this.state.disableButton} >Make Order</Button>
                            </td>
                        </tr>
                    </tbody>
                </Table>
            </div>
        )
    }
}

export default PriceList;