import React, { useState,useCallback } from 'react';
import {Link} from 'react-router-dom'
import {useDispatch} from 'react-redux'
import { saveItem } from '../reducer/item.reducer';
const ItemRegister = () =>{

    const dispatch = useDispatch()

    const [item, setNewItem] = useState({
        title : "",
        content : "",
        goalPrice : ""
    })
    const handleSubmit = useCallback(e =>{
        const {newItem, value} = e.target
        setNewItem({
            ...item,
            [newItem]: value
        })
    },[item])
    return(
        <>
        <h1>아 이 템 등 록 하 기</h1>
        <form onSubmit={handleSubmit}>
            
            <label>title</label>
            <input type="text" name="title" value={item.title} onChange={handleSubmit}/>
            <label>writer</label>
            <input type="text" name="writer" value={item.writer} onChange={handleSubmit}/>
            <label>content</label>
            <input type="text" name="content" value={item.content} onChange={handleSubmit}/>
            <label>목표금액</label>
            <input type="text" name="goalPrice" value={item.goalPrice} onChange={handleSubmit}/>
            <hr/>
        </form>
        <Link to={'/item/list'}><button type="submit" onClick={()=>dispatch(saveItem(item))}>등록</button></Link>
        <Link to={'/item/list'}><button>취소</button></Link>
        </>
    )
}

export default ItemRegister