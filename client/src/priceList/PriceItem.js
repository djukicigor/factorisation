import React from 'react';
import { FormControl, Button } from 'react-bootstrap';

function PriceItem(props) {
    const post = props.post;
    const name = `check-${post.id}`
    return(
        <tr key={post.id}>
            <td>{post.id}</td>
            <td>{post.goodsOrServices.name}</td>
            <td id='price-td'>{post.price}</td>
            <td id='price-input-td'>
                <FormControl 
                    type="number"
                    placeholder="Product price"
                    value={post.price}
                    onChange={(e) => props.handlePriceChange(e, post)}
                />
            </td>
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
            <td>
                <Button
                    type="button"
                    onClick={(e) => props.removeCallback(e, name, post)}>
                        <span className="glyphicon glyphicon-remove-sign"></span>
                </Button>
            </td>
        </tr>
    )
}

export default PriceItem;