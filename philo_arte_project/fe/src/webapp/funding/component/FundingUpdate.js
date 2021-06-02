import React, { useState, useCallback, useEffect } from 'react'
import HeaderSocial from 'webapp/common/Header/HeaderSocial'
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import HomeMarketingSlider from "webapp/funding/component/showing/HeroMarketing";
import FooterOne from "webapp/common/Footer/FooterOne";
import {Link, useParams} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {getFundingDetail, currentFunding, dtoPath,updateFunding, addFileList} from 'webapp/funding/reducer/funding.reducer'
import { Button, Grid, MenuItem, TextField, Typography } from '@material-ui/core';
import { FundingService } from '..';
const FundingUpdate = ({fundingId,title,content,hashtag, image,goalPrice}) =>{
    const dispatch = useDispatch()

    const param = useSelector(currentFunding)
    const dto = useSelector(dtoPath)
    const {update} = useParams()

    const showDetailFunding = useSelector(state =>{
        console.log("state : " + JSON.stringify(state.showDetailFunding))
        return state.showDetailFunding
      })
    const [fundings, setUpdate] = useState({
        title: '',
        content: '',
        goalPrice: '',
        hashtag : ''
    })
    const [files, setFiles] =useState([])
    const [uploadResult, setUploadResult] = useState([])
     useImperativeHandle(cref, () => ({

        send() {
            getUploadedFiles(uploadResult)
            setFiles([])
            setUploadResult([])
        }

    }));

const handleChange = e=>{
    setUpdate({
        ...fundings,
        [e.target.name]: [e.target.value]
    })
    dispatch(updateFunding(param?.fundingId,fundings))
}
const fileChange = async(e)=>{
    e.preventDefault()
    const formData = new FormData()
    const files = e.target.files

    for(let i = 0; i < files.length ; i++){
        formData.append("uploadFiles", files[i])
    }
    FundingService.fileUpload(formData)
    .then(res => {
        console.log("res = " +  JSON.stringify(res))

        res.data.forEach(uploadFileInfo =>  {uploadResult.push(uploadFileInfo)
        dispatch(addFileList({uuid: uploadFileInfo.uuid, file: uploadFileInfo}))})

        console.log("upload Result = " + JSON.stringify(uploadResult))

        setUploadResult(uploadResult.slice(0))
    })
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
    }

]
    return(
        <>
        <HeaderSocial data={dataNavbar} />
              <HomeMarketingSlider/>
        <form>
        <h1> 펀 딩 업 데 이 트</h1>
        <div className="container">
        
        <div className="card col-md-8 offset-md-3">
            
          <div> 
          <label className="form-label"> * NO </label>
          <textarea className="form-control" placeholder={param?.fundingId} rows="1" style={{color:"black"}}value={fundings.fundingId} name="fundingId" readOnly></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 제목 </label>
          <textarea className="form-control" placeholder={param?.title} rows="1" style={{color:"black"}}value={fundings.title} name="title" onChange={handleChange} ></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 내용 </label>
          <textarea className="form-control" placeholder={param?.content} rows="3" style={{color:"black"}}value={fundings.content} name="content" onChange={handleChange} ></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 목표금액 </label>
          <textarea className="form-control" placeholder={param?.goalprice} rows="1" style={{color:"black"}}value={fundings.goalPrice} name="goalPrice" onChange={handleChange} ></textarea> 
          </div>
          <div> 
          <Grid item sm ={3}>
                <TextField
                select
                label="Select Hashtag"
                value={fundings.hashtag}
                placeholder={param?.hashtag}
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

            <div style={{marginLeft:60}}>
            <Button
                variant="contained"
                component="label">
                <Typography>{"Upload"}</Typography>

                <input style={{ display: 'none' }} type="file" name="imageFile"
                       onChange={(e)=>fileChange(e)}  multiple={true}/>
            </Button>
            <div>
                <ul>
                    {uploadResult.map(uploadFile => {
                        return (
                            <div key={uploadFile.uuid}>
                                <img src={"http://localhost:8080/funding_file/display?fileName=s_" + uploadFile.uuid+"_"+ uploadFile.fname }/>
                                {uploadFile.fname}
                            </div>
                        )
                    })
                    }
                </ul>
            </div>
        </div>
            {/* <div>
            
          {param?.map((image,i)=>(
                <div key={i}>
                    <img src={`http://localhost:8080/funding_file/display?fileName=${image.uuid}_${image.fname}`}/>
                </div>
                )
            )}
            </div> */}
            </div>
          </div>
          </div>
         
        </form>
        <Link to={"/funding/list"}> <Button onClick={handleChange}>SUBMIT</Button></Link>
        <FooterOne />
        </>
    )
}
export default FundingUpdate