import React, { useState,useCallback } from 'react';
import {Link} from 'react-router-dom'
import {useDispatch} from 'react-redux'
import { saveFunding } from 'webapp/funding/reducer/funding.reducer';
const FundingRegister = () =>{

    const dispatch = useDispatch()

    const [funding, setNewFunding] = useState({
        title : "",
        content : "",
        writer:"",
        goalPrice : "",
    })
    const handleSubmit = useCallback(e =>{
        const {name, value} = e.target
        setNewFunding({
            ...funding,
            [name]: value
        })
    },[funding])
    return(
        <>
        <h1>아 이 템 등 록 하 기</h1>
        <form onSubmit={handleSubmit}>
            
            <label>title</label>
            <input type='text' name='title' value={funding.title} onChange={handleSubmit}/>
            <hr/>
            <label>writer</label>
            <input type="text" name="writer" value={funding.writer} onChange={handleSubmit}/>
            <hr/>
            <label>content</label>
            <input type="text" name="content" value={funding.content} onChange={handleSubmit}/>
            <hr/>
            <label>목표금액</label>
            <input type="text" name="goalPrice" value={funding.goalPrice} onChange={handleSubmit}/>
            <hr/>
        </form>
        <Link to={'/funding/list'}><button type="submit" onClick={()=>dispatch(saveFunding(funding))}>등록</button></Link>
        <Link to={'/funding/list'}><button>취소</button></Link>
        </>
    )
}

export default FundingRegister