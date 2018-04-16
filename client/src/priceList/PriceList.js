import React, { Component } from 'react';
import { Table, Checkbox, FormControl, Button } from 'react-bootstrap';
import PriceItem from './PriceItem.js';
import './priceList.css';

class PriceList extends Component {
    constructor() {
        super();
        this.state = {
            post: {},
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
        const priceListUrl = '/api/pricelists/' + this.props.match.params.id;
        fetch(priceListUrl, {
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

    makeOrder() {
        fetch('https://api.github.com/gists', {
            method: 'post',
            body: JSON.stringify("{}")
        }).then(function(response) {
            return response.json();
        }).then(function(data) {
            // console.log(data);
        });
    }

    renderPriceList(items) {
        let checkboxes = this.state.checkboxes;
        let po;

        if(items){
            po = items.map((item) => {
                if (!checkboxes[`check-${item.id}`]) {
                    checkboxes[`check-${item.id}`] = false;
                }
                return(
                    <PriceItem
                        key={item.id}
                        post={item}
                        changeCallback={this.handleChange}
                        checked={checkboxes[`check-${item.id}`]}
                        changeTextCallback={this.handleTextChange}
                    />
                );
            })
        }
        return po;
    }

    render() {
        let post = this.state.post;
        return (
            <div className="price-list">
                {post ? 
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
                                {this.renderPriceList(this.state.post.pricelist_Items)}
                                <tr>
                                    <td colSpan="4">
                                        <p></p>
                                    </td>
                                    <td className="submit-td">
                                        <Button type="submit" disabled={this.state.disableButton} onClick={this.makeOrder} >Make Order</Button>
                                </td>
                                </tr>
                            </tbody>
                        </Table>
                : "Loading"}
            </div>
        )
    }
}

export default PriceList;