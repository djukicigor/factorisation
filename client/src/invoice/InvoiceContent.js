import React from 'react';
import { Well, Grid, Row, Col } from 'react-bootstrap';

function InvoiceContent(props) {
    const post = props.post;
    return(
        <Well key={post.id}>
            <Grid>
                <Row className="show-grid">
                    <Col md={3}>
                        ####################
                        #{post.invoiceNumber}
                    </Col>
                    <Col md={3}>
                        Company: {post.amount}
                    </Col>
                    <Col md={3}>
                        Date: {post.paymentAmount}
                    </Col>
                    <Col md={3}>
                        {/* Total: {post.invoice.businessPartner.company.name}             */}
                    </Col>
                </Row>
            </Grid>
        </Well>
    )
}

export default InvoiceContent;