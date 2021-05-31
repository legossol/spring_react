import React, { useState,useCallback, useRef } from 'react';
import {Link} from 'react-router-dom'
import {useDispatch} from 'react-redux'
import { saveFunding } from 'webapp/funding/reducer/funding.reducer';
import { Button, colors } from '@material-ui/core';
import FileRegister from './register/FileRegister';
import TextRegister from './register/TextRegister';
import axios from 'axios'
const FundingRegister = () =>{

    const childRef = useRef()
    let uploadedFiles = null

    const sendTextForm = (title, content) => {
        childRef.current.send()
        console.log(uploadedFiles)


        const data = {title:title, content:content, pictures:uploadedFiles}

        axios.post("http://localhost:8080/funding/register", data)

    }

    const getUploadedFiles = (uplodedFilesResult) => {
        console.log("getUploadedFiles")
        uploadedFiles = uplodedFilesResult
    }
    return(
        <>
        <div>
            <TextRegister sendTextForm = {sendTextForm}></TextRegister>
            <FileRegister cref={childRef} getUploadedFiles = {getUploadedFiles}></FileRegister>
        
        </div>
        {/* <Link to={'/funding/list'}><button type="submit" onClick={()=>dispatch(saveFunding(funding))}>등록</button></Link>
        <Link to={'/funding/list'}><button>취소</button></Link> */}
        </>
    )
}

export default FundingRegister

