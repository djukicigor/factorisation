import React from 'react';
import { FormControl } from 'react-bootstrap';

function Good(props) {
    const post = props.post;
    const name = `check-${post.id}`
    return(
        <tr>
            <td>{post.id}</td>
            <td>{post.name}</td>
            <td>{post.unit}</td>
            <td className="price-td">
                <FormControl 
                    type="number"
                    placeholder="Price" 
                    disabled={!props.checked}
                    onChange={props.changeTextCallback.bind(this)}
                />
            </td>
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