import React from 'react';
import { FormControl } from 'react-bootstrap';

function PriceItem(props) {
    const post = props.post;
    const name = `check-${post.id}`
    return(
        <tr key={post.id}>
            <td>{post.id}</td>
            <td>{post.goodsOrServices.name}</td>
            <td>{post.price}</td>
            <td>{post.goodsOrServices.unit}</td>
            <td className="ammount-td">
                <FormControl 
                    type="number"
                    placeholder="Ammount" 
                    disabled={!props.checked}
                    onChange={(e) => props.changeTextCallback(e, post)}
                />
            </td>
            <td>
                <FormControl
                    name={name}
                    type="checkbox"
                    checked={props.checked}
                    onChange={(e) => props.changeCallback(e, name, post)}
                />
            </td>
        </tr>
    )
}

export default PriceItem;