import React from 'react';
import { FormControl, Button } from 'react-bootstrap';

function Good(props) {
    const post = props.post;
    const name = `check-${post.id}`
    return(
        <tr>
            <td>{post.id}</td>
            <td>{post.name}</td>
            <td>{post.unit}</td>
            <td>
            <Button
                type="button"
                onClick={(e) => props.addItem(e, name, post)}>
                    <span className="glyphicon glyphicon-plus-sign"></span>
            </Button>
            </td>
        </tr>
    )
}

export default Good;