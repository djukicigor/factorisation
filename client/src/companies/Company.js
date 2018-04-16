import React from 'react';
import { BrowserRouter as Router, Link } from 'react-router-dom';
import { Well, Grid, Row, Col } from 'react-bootstrap';

function Company(props) {
    const post = props.post;
    return(
        <Link to={'/pricelist/' + post.id}> 
            <Well key={post.id}>
                <Grid>
                    <Row className="show-grid">
                        <Col md={3}>
                            #{post.id}
                        </Col>
                        <Col md={3}>
                            {/* Company: {post.company.name} */}
                        </Col>
                        <Col md={3}>
                            {/* Date: {post.invoiceDate} */}
                        </Col>
                        <Col md={3}>
                            {post.name}            
                        </Col>
                    </Row>
                </Grid>
            </Well>
        </Link>
    )
}

export default Company;