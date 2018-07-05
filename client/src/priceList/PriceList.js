import React, { Component } from 'react';
import { Table, Checkbox, FormControl, Button } from 'react-bootstrap';
import PriceItem from './PriceItem.js';
import './priceList.css';

let cachedPost = {};

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
            submitText: "Make an Order"
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleRemove = this.handleRemove.bind(this);
        this.handleTextChange = this.handleTextChange.bind(this);
        this.handlePriceChange = this.handlePriceChange.bind(this);
        this.makeOrder = this.makeOrder.bind(this);
        this.saveList = this.saveList.bind(this);
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

    saveList() {
        console.log('save');
        console.log(this.state.post);
        let saveObject = this.state.post;
        let checker = true;
        saveObject.pricelist_Items.forEach(function(element) {
            if(!element.price) {
                checker = false;
            }
        });
        console.log(JSON.stringify(this.state.post));
        if(checker) {
            delete saveObject.id;
            saveObject.date_of_validity = new Date();
            saveObject.pricelist_Items.forEach(function(element) {
                delete element.id;
            });
            console.log(JSON.stringify(this.state.post));
            console.log(JSON.stringify(this.state.post));
            fetch('/api/pricelists', {
                method: 'POST',
                headers : {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(saveObject)
            }).then(function(response) {
                return response.json();
            }).then(function(data) {
                alert('pricelist saved')
            });
        }
        else {
            alert('Please enter correct price');
        }
    }

    handleRemove(event, name, post) {
        console.log(cachedPost.pricelist_Items);
        console.log(post);
        cachedPost.pricelist_Items = cachedPost.pricelist_Items.filter(function( obj ) {
            return obj.id !== post.id;
        });
        this.setState({post: cachedPost});
    }

    handleTextChange(event, post) {
        const el = event.target.value;
        let index = this.state.added.indexOf(post);
        this.state.added[index].amount = event.target.value;
        if (el.length > 0 && !this.state.buttonBlocked) {
            this.setState({ disableButton: false })
        }
    }

    handlePriceChange(event, post) {
        const el = event.target.value;
        post.price = parseInt(el);
        this.setState({post: cachedPost});
    }

    componentDidMount() {
        const priceListId = (this.props.match) ? this.props.match.params.id : this.props.priceListId;
        const priceListUrl = '/api/pricelists/' + priceListId;
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
            if(!element.amount) checking = false;
        });
        if(checking){
            let jsonList = []
            this.state.added.forEach(function(element) {
                let parseJson = {
                    "id": element.id,
                    "amount": parseInt(element.amount),
                    "unitPrice": parseInt(element.price),
                    "percentagePDV": element.goodsOrServices.groupOfGoods.percentage,
                    "amountItems": 1,
                    "goodsOrservicesId": element.goodsOrServices.id,
                    "companyId": parseInt(self.props.match.params.id),
                    "pricelistId": parseInt(self.props.match.params.id),
                    "businessPartnerId": parseInt(sessionStorage.getItem('id')),
                }
                jsonList.push(parseJson);
            });
            fetch('/api/invoiceitems', {
                method: 'POST',
                headers : {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(jsonList)
            }).then(function(response) {
                return response.json();
            }).then(function(data) {
                self.setState({
                    disableButton: true,
                    buttonBlocked: true,
                    submitText: "Order Made",
                })
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
                        removeCallback={this.handleRemove}
                        checked={checkboxes[`check-${item.id}`]}
                        changeTextCallback={this.handleTextChange}
                        handlePriceChange={this.handlePriceChange}
                    />
                );
            })
        }
        return po;
    }

    componentWillReceiveProps(nextProps) {
        nextProps.priceListItems.forEach(function(element) {
            let exists = false;
            cachedPost.pricelist_Items.forEach(function(item){
                console.log(item)
                console.log(item.id + '/' + item.goodsOrServices.name + '/' + element.id +'/' + element.name)
                if (item.id === element.id || item.goodsOrServices.name === element.name) {
                    exists = true;
                }
            });
            if(!exists){
                console.log('pushed');
                cachedPost.pricelist_Items.push(element);
            }
        });
        this.setState({post: cachedPost});
    }

    render() {
        let post = this.state.post;
        cachedPost = this.state.post;
        return (
            <div className="price-list">
                {post ?
                    <Table striped bordered condensed hover>
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Price</th>
                                    <th>Unit</th>
                                    <th>Ammount</th>
                                    <th>Add to Cart</th>
                                    <th>Remove from Price List</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.renderPriceList(this.state.post.pricelist_Items)}
                                <tr>
                                    <td>
                                        <p></p>
                                    </td>
                                    <td colSpan="4">
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
                                    <td className="submit-td">
                                        <Button
                                            type="button"
                                            onClick={this.saveList}>
                                                Save Price List
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