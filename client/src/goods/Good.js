import React from 'react';
import { FormControl } from 'react-bootstrap';

function Good(props) {
    const post = props.post;
    const name = `check-${post.id}`
    return(
        <tr>
            <td>{post.id}</td>
            <td>{post.naziv}</td>
            <td>{post.mera}</td>
            <td>
            <FormControl
                name={name}
                type="checkbox"
                checked={props.checked}
                onChange={(e) => props.changeCallback(e, name)}
            />
            </td>
        </tr>
    )
}

export default Good;