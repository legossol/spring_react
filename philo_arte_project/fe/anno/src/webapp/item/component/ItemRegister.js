import React, { useState } from 'react';
import {Link} from 'react-router-dom'
import {useDispatch} from 'react-redux'
import { itemRegister } from '../reducer/item.reducer';
const ItemRegister = () =>{

    const dispatch = useDispatch()

    const [item, setItem] = useState({
        title : "",
        writer : "",
        content : "",
        goalPrice : ""
    })
    const onCreate = e =>{
        e.preventDefault();
        if(item){
            const newItem = { title: item.title, writer: item.writer, content: item.content, goalPrice: item.goalPrice}
            dispatch(itemRegister(newItem))
            setItem("")
        }else{
            console.log("등록 완료 전")
        }
    }
    return(
        <>
        <h1>아 이 템 등 록 하 기</h1>
        <form onSubmit={onCreate}>
            
            <label>title</label>
            <input type="text" name="title" value={item.title} onChange={e => setItem(e.target.value)}/>
            <label>writer</label>
            <input type="text" name="writer" value={item.writer} onChange={e => setItem(e.target.value)}/>
            <label>content</label>
            <input type="text" name="content" value={item.content} onChange={e => setItem(e.target.value)}/>
            <label>목표금액</label>
            <input type="text" name="goalPrice" value={item.goalPrice} onChange={e => setItem(e.target.value)}/>
            <Link to={'/item/list'}><button type='submit'>등록</button></Link>
            <Link to={'/item/list'}><button>취소</button></Link>
            

        </form>
        </>
    )
}

export default ItemRegister