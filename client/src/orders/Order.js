import React from 'react';
import Moment from 'react-moment';
import { BrowserRouter as Router, Link } from 'react-router-dom';
import { Well, Grid, Row, Col } from 'react-bootstrap';

function Order(props) {
    const post = props.post;
    return(
        <Link to={'/invoice/' + post.id}> 
            <Well key={post.id}>
                <Grid>
                    <Row className="show-grid">
                        <Col md={3}>
                            #{post.invoiceNumber}
                        </Col>
                        <Col md={3}>
                            Company: {post.company.name}
                        </Col>
                        <Col md={3}>
                            <Moment unix>{post.invoiceDate}</Moment>
                        </Col>
                        <Col md={3}>
                            Total: {post.paymentAmount}            
                        </Col>
                    </Row>
                </Grid>
            </Well>
        </Link>
    )
}

export default Order;