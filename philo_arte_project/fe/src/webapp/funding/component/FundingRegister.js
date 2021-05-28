import React, { useState,useCallback, useRef } from 'react';
import {Link} from 'react-router-dom'
import {useDispatch} from 'react-redux'
import { saveFunding } from 'webapp/funding/reducer/funding.reducer';
import { colors } from '@material-ui/core';
const FundingRegister = () =>{

    const childdRef = useRef()
    let uploadedFiles = null

    const getUploadedFiles = (uplodedFilesResult) => {
        console.log("getUploadedFiles")
        uploadedFiles = uplodedFilesResult
    }

    //======


    const dispatch = useDispatch()

    const [funding, setNewFunding] = useState({
        title : "",
        content : "",
        goalPrice : "",
        viewCnt:"",
        hashtag : "",
        artistId:""
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
        
        <h1>전부 등록하기</h1>
        <form >
            
            <label>title</label>
            <input type='text' style={{color:'black'}} name='title' value={funding.title} onChange={handleSubmit}/>
            <hr/>
            <label>content</label>
            <input type="text"style={{color:'black'}} name="content" value={funding.content} onChange={handleSubmit}/>
            <hr/>
            <label>목표금액</label>
            <input type="number"style={{color:'black'}} name="goalPrice" value={funding.goalPrice} onChange={handleSubmit}/>
            <label>해쉬태그</label>
            <input type="text" style={{color:'black'}}name="hashtag" value={funding.hashtag} onChange={handleSubmit}/>
            <label>viewCnt</label>
            <input type="number"style={{color:'black'}} name="viewCnt" value={funding.viewCnt} onChange={handleSubmit}/>
            <label>artistId</label>
            <input type="number"style={{color:'black'}} name="artistId" value={funding.artistId} onChange={handleSubmit}/>
            <hr/>
            <input type="file" onChange={handleSubmit}/>
        </form>
        <Link to={'/funding/list'}><button type="submit" onClick={()=>dispatch(saveFunding(funding))}>등록</button></Link>
        <Link to={'/funding/list'}><button>취소</button></Link>
        </>
    )
}

export default FundingRegister

