import React from 'react';
import {render} from 'react-dom';
import Moment from 'react-moment';
import { Well, Grid, Row, Col, Table, Glyphicon, Button } from 'react-bootstrap';

function InvoiceContent(props) {
    let post = props.post;
    let company = post.company;
    let invoiceItems;
    let totalPDV = 0;
    let totalBase = 0;
    let totalPrice = 0;
    let status = (post.invoiceStatus == 0) ? (
        <h4 className="invoice-rejected"><Glyphicon glyph="remove" /> REJECTED</h4>
      ) : (post.invoiceStatus == 2) ? (
        <h4 className="invoice-approved"><Glyphicon glyph="ok" /> APPROVED</h4>
      ): (
        <h4 className="invoice-pending"><Glyphicon glyph="file" /> PENDING</h4>          
    );
    let pending = (post.invoiceStatus == 1) ? (
        <div>
            <Button
                className="approve-btn"
                type="button"
                onClick={(e) => props.invoiceForward(e, post, 2)}>
                Approve!
            </Button>
            <Button
                className="reject-btn"
                type="button"
                onClick={(e) => props.invoiceForward(e, post, 0)}>
                Reject!
            </Button>
        </div>
    ) : <div></div>;
    let buttons;
    if(!props.buttonsState) {
        buttons = (sessionStorage.getItem('type') == 'company') ? pending : <div></div>;
    }
    else{
        buttons = (<div>Invoice Finalized</div>)
    }
    if(company) {
        invoiceItems = post.invoice_Items.map((item, index) =>
            <tr key={index}>
                <td className="invisible-td">
                    {totalPDV += (item.unitPrice / 100) * item.percentagePDV * item.amount}
                    {totalBase += item.unitPrice * item.amount}
                    {totalPrice = totalBase + totalPDV}
                </td>
                <td>
                    {index}
                </td>
                <td>
                    {item.goodsOrServices.name}
                </td>
                <td>
                    {item.goodsOrServices.unit}
                </td>
                <td>
                    {item.amount}
                </td>
                <td>
                    {item.unitPrice}
                </td>
                <td>
                    {item.percentagePDV}
                </td>
                <td>
                    {(item.unitPrice / 100) * item.percentagePDV}
                </td>
                <td>
                    {(item.unitPrice / 100) * item.percentagePDV + item.unitPrice}
                </td>
                <td>
                    {item.unitPrice * item.amount}
                </td>
                <td>
                    {(item.unitPrice / 100) * item.percentagePDV * item.amount}
                </td>
                <td>
                    {((item.unitPrice / 100) * item.percentagePDV * item.amount) + (item.unitPrice * item.amount)}
                </td>
            </tr>  
        );
    }
    return(
        <Grid className="invoice-content" >
            {post.company? 
                <Well key={post.id}>
                    <h1>{post.company.name}</h1>
                    <Row>
                        <Col md={3}>
                            <span>
                                {company.address}, {company.city.postalCode}, {company.city.name}
                            </span>
                        </Col>
                        <Col md={6}></Col>
                        <Col md={3}>
                            <span>
                                Phone: {company.number}
                            </span>
                        </Col>
                    </Row>
                    <hr/>
                    <Row className="show-grid">
                        <Col md={5}>
                            <p>
                                Bill number: 
                                <strong>
                                    {post.id}/{post.businessYear.year}
                                </strong>
                            </p>
                        </Col>
                        <Col md={3}>
                        </Col>
                        <Col className="left-col" md={2}>
                            <p>Date:</p>
                            <p>City:</p>
                            <p>Buyer id:</p>
                        </Col>
                        <Col className="right-col" md={2}>
                            <p><Moment unix format="DD MMM YYYY">{post.invoiceDate}</Moment></p>
                            <p>{company.city.name}</p>
                            <p>{post.businessPartner.id}</p>
                        </Col>
                    </Row>
                    <br/>
                    <Row className="show-grid">
                        <Col md={5}>
                            <Table striped bordered condensed>
                                <thead>
                                    <tr>
                                        <th>Buyer:</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody> 
                                    <tr>
                                        <td>
                                            Name:
                                        </td>
                                        <td>
                                            {post.businessPartner.name}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Adress:
                                        </td>
                                        <td>
                                            {post.businessPartner.city.name},{post.businessPartner.address}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            ID number:
                                        </td>
                                        <td>
                                            {post.businessPartner.id}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            PIB
                                        </td>
                                        <td>
                                            Pib number
                                        </td>
                                    </tr>
                                </tbody>
                            </Table>
                        </Col>
                        <Col md={3}>
                        </Col>
                        <Col md={4}>
                            <Table striped bordered condensed>
                                <thead>
                                    <tr>
                                        <th>Seller:</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody> 
                                    <tr>
                                        <td>
                                            ID number:
                                        </td>
                                        <td>
                                            {company.id}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            PIB
                                        </td>
                                        <td>
                                            {company.pib}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Account Number
                                        </td>
                                        <td>
                                            825-2555955-95
                                        </td>
                                    </tr>
                                </tbody>
                            </Table>
                        </Col>
                    </Row>
                    <br/>
                    <Row>
                        <Col md={12}>
                            <Table className="invoice-items" striped bordered condensed>
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Name</th>
                                        <th>Unit</th>
                                        <th>Ammount</th>
                                        <th>Unit Price</th>
                                        <th>Tax(%)</th>
                                        <th>Tax Per Piece</th>
                                        <th>Total Piece Price</th>
                                        <th>Total Base Price</th>
                                        <th>Total Tax</th>
                                        <th>Total Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {invoiceItems}
                                </tbody>
                            </Table>
                        </Col>
                    </Row>
                    <Row>
                        <Col md={4}>
                            {status}
                        </Col>
                        <Col md={4}>
                            {buttons}
                        </Col>
                        <Col className="total-labels" md={2}>
                            <p><strong> Total Base: </strong></p>
                            <p><strong> Total Tax: </strong></p>
                            <h4><strong> Total Price: </strong></h4>                            
                        </Col>
                        <Col className="total-price" md={2}>
                            <p>{totalBase}</p>
                            <p>{totalPDV}</p>
                            <h4><strong> {totalPrice} </strong></h4>      
                        </Col>                        
                    </Row>
                </Well>
            : "Loading"}
        </Grid>    
    )
}

export default InvoiceContent;