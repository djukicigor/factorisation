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
            <td className="ammount-td"><FormControl type="text" placeholder="Ammount" disabled/></td>
            <td>
                <FormControl
                    name={name}
                    type="checkbox"
                    checked={props.checked}
                    onChange={props.changeCallback.bind(name)}
                />
            </td>
        </tr>
    )
}

export default PriceItem;