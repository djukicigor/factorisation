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
            added: [],
            disabled: true,
            disableButton: true,
            buttonBlocked: false,
            checked: false,
            submitText: "Add to Price List",
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleTextChange = this.handleTextChange.bind(this);
        this.makeOrder = this.makeOrder.bind(this);
    };

    handleChange(event, name, post) {
        const checkboxes = this.state.checkboxes;
        checkboxes[name] = !checkboxes[name];
        if(checkboxes[name]){
            this.state.added.push(post);
        }
        else{
            let index = this.state.added.indexOf(post);
            if (index !== -1) this.state.added.splice(index, 1);
        }
        this.setState({
            checkboxes,
            disabled:false
        })
    }

    handleTextChange(event, post) {
        const el = event.target.value;
        let index = this.state.added.indexOf(post);
        this.state.added[index].price = event.target.value; 
        if (el.length > 0 && !this.state.buttonBlocked) { 
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
        const self = this;
        let checking = true;
        this.state.added.forEach(function(element) {
            if(!element.price) checking = false;
        });
        if(checking){
            this.state.added.forEach(function(element) {
                console.log(element)
                let parseJson = {
                    "id": element.id,
                    "amount": 1,
                    "unitPrice": parseInt(element.price),
                    "percentagePDV": element.goodsOrServices.groupOfGoods.percentage,
                    "amountItems": 1,
                    "goodsOrservicesId": element.goodsOrServices.id,
                    "companyId": parseInt(self.props.match.params.id),
                    "businessPartnerId": 1
                }
                console.log(parseJson)
                fetch('/api/invoiceitems', {
                    method: 'POST',
                    headers : {
                        'Content-Type': 'application/json',
                        'Accept': 'application/json'
                    },
                    body: JSON.stringify(parseJson)
                }).then(function(response) {
                    return response.json();
                }).then(function(data) {
                    self.setState({
                        disableButton: true,
                        buttonBlocked: true,
                        submitText: "Added to Price List",
                    })
                });
            });
        }
        else {
            alert("Enter prices for all checked Goods!")
        }
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
                                    <th>Price</th>
                                    <th>Unit</th>
                                    <th>Ammunt</th>
                                    <th>Add to Cart</th>
                                </tr>
                            </thead>
                            <tbody> 
                                {this.renderPriceList(this.state.post.pricelist_Items)}
                                <tr>
                                    <td colSpan="5">
                                        <p></p>
                                    </td>
                                    <td className="submit-td">
                                    <Button 
                                        type="button" 
                                        disabled={this.state.disableButton} 
                                        onClick={this.makeOrder}>
                                            {this.state.submitText}
                                    </Button>
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