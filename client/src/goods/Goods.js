import React, { Component } from 'react';
import { Table, Button, Pagination,  } from 'react-bootstrap';
import './goods.css';
import Good from './Good.js';

class Goods extends Component {
    constructor() {
        super();
        this.state = {
            posts: [],
            added: [],
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
            console.log(data)
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
                    "id": Math.round( Math.random() * 10000),
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
                    changeCallback={this.handleChange}
                    checked={checkboxes[`check-${post.id}`]}
                    changeTextCallback={this.handleTextChange}
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
            console.log(data)
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
                <Pagination.Item onClick={this.changePage.bind(this)} active={number === active}>{number}</Pagination.Item>
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
                <form>
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
                                    <Button
                                        type="button"
                                        disabled={this.state.disableButton}
                                        onClick={this.addToPriceList}>
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