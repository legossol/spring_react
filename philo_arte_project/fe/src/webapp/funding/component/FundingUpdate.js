import React, { useState, useCallback, useEffect, useRef, useImperativeHandle } from 'react'
import HeaderSocial from 'webapp/common/Header/HeaderSocial'
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import HomeMarketingSlider from "webapp/funding/component/showing/HeroMarketing";
import FooterOne from "webapp/common/Footer/FooterOne";
import {Link, useParams} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {updateFunding, deleteFile} from 'webapp/funding/reducer/funding.reducer'
import { Button, Grid, MenuItem, TextField, Typography } from '@material-ui/core';
import fundingService from 'webapp/funding/service/funding.service';
import FileRegister from './register/FileRegister';
import { current } from '@reduxjs/toolkit';
import axios from 'axios';
import DeleteForeverIcon from '@material-ui/icons/DeleteForever';

const FundingUpdate = () =>{
    const dispatch = useDispatch()
    const param = useSelector(state => state.fundings.current)
    const {update}=useParams()
    const childRef = useRef()

    let uploadedFiles = null
    const [files, setFiles]=useState([])

    const [data, setUpdate] = useState({
        title:param.title,
        content: param.content,
        goalPrice: param.goalPrice,
        hashtag : param.hashtag,
        fundingFiles: param.fundingFiles
        
    })


    const {title,content,goalPrice,hashtag,fundingFiles}=data

    const handleChange =useCallback((e)=>{
        setUpdate({
            ...data,
            [e.target.name]: [e.target.value]
        },[data])
        console.log(JSON.stringify(data))
    });

    const getUploadedFiles = (uplodedFilesResult) => {
        setFiles(uplodedFilesResult)
        console.log(uploadedFiles)
    }
    
//     const getPrevData = () =>{
//         return new Promise((resolve,reject)=>{
//             setTimeout(()=>{
//                 resolve(data)
//             });
//         },2000);
//     }

    
//    useEffect(()=>{
//        console.log("========useEffect========")
//         const fetchPrevData = async()=>{
//             const fundingData = await getPrevData();
//             setUpdate(fundingData)
//         }
//         fetchPrevData();
//    },[])
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
          <textarea className="form-control"  rows="1" style={{color:"black"}}value={title} name="title"  onChange={handleChange} ></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 내용 </label>
          <textarea className="form-control"  rows="3" style={{color:"black"}}value={content} name="content" onChange={handleChange} ></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 목표금액 </label>
          <textarea className="form-control"  rows="1" style={{color:"black"}}value={goalPrice} name="goalPrice" onChange={handleChange} ></textarea> 
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
            <hr/>
            {param.fundingFiles?.map((image,i)=>(
                <div key={i}>
                    기존 사진
                    <img src={`http://localhost:8080/funding_file/display?fileName=${image.uuid}_${image.fname}`}/>
                    <hr/>

                    <DeleteForeverIcon><Button onclick={(id)=>deleteFile(id)}></Button></DeleteForeverIcon>
                </div>
                )
            )}
            <hr/>
            <div>추가될 사진</div>
            <FileRegister cref={childRef} getUploadedFiles = {getUploadedFiles} onChange={data.fundingFiles}></FileRegister>
            
            </div>

          </div>
          </div>
          <Button onClick={(e)=>subMit(e)}>SUBMIT</Button>
      <Link to={"/funding/list"}>링크입니다 </Link>
    </form>
<FooterOne />
        </>
    )
}
export default FundingUpdate