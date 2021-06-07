import React, { useState, useCallback, useEffect, useRef, useImperativeHandle, Fragment } from 'react'
import HeaderSocial from 'webapp/common/Header/HeaderSocial'
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import HomeMarketingSlider from "webapp/funding/component/showing/HeroMarketing";
import FooterOne from "webapp/common/Footer/FooterOne";
import {Link, useParams} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {updateFunding, deleteFile, getFundingDetail} from 'webapp/funding/reducer/funding.reducer'
import { Button, Checkbox, Grid, IconButton, ListItem, MenuItem, TextField, Typography } from '@material-ui/core';
import fundingService from 'webapp/funding/service/funding.service';
import FileRegister from './register/FileRegister';
import { current } from '@reduxjs/toolkit';
import axios from 'axios';
import ListItemText from "@material-ui/core/ListItemText";
import ListItemSecondaryAction from "@material-ui/core/ListItemSecondaryAction";

import { Delete, Edit } from "@material-ui/icons";
import ImagesUploader from './image/ImageUploader';

const FundingUpdate = () =>{
    const dispatch = useDispatch()
    const param = useSelector(state => state.fundings.current)
    const {update}=useParams()
    const childRef = useRef()

    let uploadedFiles = null

    const [data, setUpdate] = useState({
        fundingId: param.fundingId,
        title:param.title,
        content: param.content,
        goalPrice: param.goalPrice,
        hashtag : param.hashtag,
        fundingFiles: uploadedFiles
    })

    const handleChange =useCallback((e)=>{
      const {name, value} = e.target;
        setUpdate({
          ...data,
          [name]:value
        })
        console.log(JSON.stringify(data))
    });

    const getUploadedFiles = (uplodedFilesResult) => {
        
        uploadedFiles = uplodedFilesResult
        setUpdate(uplodedFilesResult)
        data.fundingFiles = uploadedFiles
    }

useEffect(()=>{
    const fetchData = async() =>{
        const result = await axios(`http://localhost:8080/funding/${update}`);
        setUpdate(result.data)
}
fetchData();
},[])

   const fundingId = param.fundingId

   const subMit = (e) =>{
       e.preventDefault()
       e.stopPropagation()
       childRef.current.send()
       dispatch(updateFunding({fundingId, data}))

   }
const hashtags = [
    {
        value:'약',
        label:'약'
    },
    {
        value:'건강기능',
        label:'건강기능'
    },
    {
        value:'여행',
        label:'여행'
    },
    {
        value:'화장품',
        label:'화장품'
    }

]
const [checked, setChecked] = useState(true)
const handleCheck = e =>{
    setChecked(e.target.checked)
}

    return(
        <>
        <HeaderSocial data={dataNavbar} />
              <HomeMarketingSlider/>
        <form>
        <h1> 펀 딩 업 데 이 트</h1>
        <div className="container">
        
        <div className="card col-md-8 offset-md-3" >
            
          <div> 
          <label className="form-label"> * NO </label>
         
          <textarea className="form-control"  rows="1" style={{color:"black"}}value={data.fundingId} name="fundingId" readOnly></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 제목 </label>
          <textarea className="form-control"  rows="1" style={{color:"black"}}value={data.title} name="title"  onChange={handleChange} ></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 내용 </label>
          <textarea className="form-control"  rows="3" style={{color:"black"}}value={data.content} name="content" onChange={handleChange} ></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 목표금액 </label>
          <textarea className="form-control"  rows="1" style={{color:"black"}}value={data.goalPrice} name="goalPrice" onChange={handleChange} ></textarea> 
          </div>
          <div> 
          <Grid item sm ={3}>
                <TextField
                select
                label="Select Hashtag"
                value={data.hashtag}
                onChange={handleChange} 
                name="hashtag"
                helperText="Please select your Funding Hashtag"
                variant="filled"
                >
                {hashtags.map((option) => (
                    <MenuItem key={option.value} value={option.value}>
                    {option.label}
                    </MenuItem>
                ))}
            </TextField>
            </Grid>
            {/* <ImagesUploader></ImagesUploader> */}
            <hr/>
            
            {param.fundingFiles?.map((image,i)=>(
                <Grid item xs={12} >
                  <Checkbox inputProps={{ 'aria-label': 'uncontrolled-checkbox' }}  style={{rotate:15}}/>
                    <img src={`http://localhost:8080/funding_file/display?fileName=${image.uuid}_${image.fname}`} style={{height:"20%", width:"20%"}} />
                    <button type="button" onClick={()=>dispatch(deleteFile(image.fundingFileId))}>사진 삭제</button>
                </Grid>
                )
            )}
            <hr/>
            <div>추가될 사진</div>
            <FileRegister cref={childRef} getUploadedFiles = {getUploadedFiles}></FileRegister>
            
            </div>
            <hr/>
            <Link to={"/funding/list"}>
          <Button variant="outlined"
                  size="large"
                  color="primary" onClick={(e)=>subMit(e)}>SUBMIT</Button>
          </Link>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <Link to={"/funding/list"}>
          <Button variant="outlined"
                  size="large"
                  color="primary" onClick={(e)=>subMit(e)}>리스트로 되돌아가기</Button>
          </Link>
          </div>
          </div>
          
    </form>
<FooterOne />
        </>
    )
}
export default FundingUpdate