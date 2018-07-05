import React, { Component } from 'react';
import { Table, Button, Pagination,  } from 'react-bootstrap';
import './goods.css';
import Good from './Good.js';
import PriceList from '../priceList/PriceList';

class Goods extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
            added: [],
            newItems: [],
            disabled: true,
            disableButton: true,
            buttonBlocked: false,
            checked: false,
            submitText: "Add to Price List",
            checkboxes: {},
            active: 1,
            numberOfPages: 0
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleTextChange = this.handleTextChange.bind(this);
        this.addToPriceList = this.addToPriceList.bind(this);
        this.addItem = this.addItem.bind(this);
    };

    addItem(event, name, post) {
        console.log(post);
        let sendingPost = post;
        sendingPost.goodsOrServices = {name: sendingPost.name,unit: sendingPost.unit}
        this.state.newItems.push(sendingPost)
        this.setState({
            disabled: false,
        })
    }

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
            disabled: false,
            checkboxes,
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

    componentWillMount() {
        fetch('/api/goodsorservices/getPages/0', {
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
        fetch('/api/goodsorservices/getPages', {
            headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(results => {
            return results.json();
        })
        .then(data => {
            const numberOfPages = data;
            this.setState({
                numberOfPages,
            });
        })
    }

    addToPriceList() {
        const self = this;
        let checking = true;
        this.state.added.forEach(function(element) {
            if(!element.price) checking = false;
        });
        if(checking){
            this.state.added.forEach(function(element) {
                let parseJson = {
                    "price": element.price,
                    "pricelistId": parseInt(sessionStorage.getItem('id')),
                    "goodsOrServicesId": element.id
                }
                fetch('/api/pricelistitems', {
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
                    addItem={this.addItem}
                    checked={checkboxes[`check-${post.id}`]}
                />
            );
        })
        return po;
    }

    changePage(e) {
        const val = parseInt(e.target.text) - 1;
        const self = this;
        fetch('/api/goodsorservices/getPages/' + val, {
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
                active: val + 1,
            });
        })
    }

    pagination() {
        let active = this.state.active;
        let items = [];
        for (let number = 1; number <= this.state.numberOfPages; number++) {
            items.push(
                <Pagination.Item onClick={this.changePage.bind(this)} key={number} active={number === active}>{number}</Pagination.Item>
            );
        }

        return (
            <div>
                <Pagination bsSize="large">{items}</Pagination>
            </div>
        );
    }

    render() {
        return (
            <div className="goods-list">
                <h3>Your Price List</h3>
                <PriceList priceListId={this.props.match.params.id} priceListItems={this.state.newItems} />
                <h3>List of Goods</h3>
                <form>
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
                                    <Button
                                        type="button"
                                        disabled={this.state.disableButton}
                                        onClick={this.addItem}>
                                            {this.state.submitText}
                                    </Button>
                                </td>
                            </tr>
                        </tbody>
                    </Table>
                    {this.pagination()}
                </form>
            </div>
        )
    }
}

export default Goods;