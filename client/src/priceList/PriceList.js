import React, { Component } from 'react';
import { Table, Checkbox, FormControl, Button } from 'react-bootstrap';
import './priceList.css';

class PriceList extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
            disabled: true
        }

        this.handleChange = this.handleChange.bind(this);
    };

    handleChange(event) {
        event.preventDefault()
        var el = event.target
        console.log(el)
        this.setState( {disabled: false} )
    }

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
            data = [{"id":1,"naziv":"stolica","mera":"kom"},{"id":2,"naziv":"brasno","mera":"kg"},{"id":3,"naziv":"sto","mera":"kom"}]
            var posts = data.map((post) => {
                return(
                    <tr>
                        <td>{post.id}</td>
                        <td>{post.naziv}</td>
                        <td>{post.mera}</td>
                        <td className="ammount-td"><FormControl type="text" placeholder="Ammount" disabled/></td>
                        <td><Checkbox>Buy</Checkbox></td>
                    </tr>
                )
            })
            
            this.setState({posts: posts});
            console.log("state", this.state.posts); 
        })
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
                        {this.state.posts}
                        <tr>
                            <td colSpan="4">
                                <p></p>
                            </td>
                            <td className="submit-td">
                                <Button type="submit" disabled>Make Order</Button>
                            </td>
                        </tr>
                    </tbody>
                </Table>
            </div>
        )
    }
}

export default PriceList;