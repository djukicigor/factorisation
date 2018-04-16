import React from 'react';
import { FormControl } from 'react-bootstrap';

function PriceItem(props) {
    const post = props.post;
    const name = `check-${post.id}`
    return(
        <tr key={post.id}>
            <td>{post.id}</td>
            <td>{post.naziv}</td>
            <td>{post.mera}</td>
            <td className="ammount-td">
                <FormControl 
                    type="number"
                    placeholder="Ammount" 
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

export default PriceItem;