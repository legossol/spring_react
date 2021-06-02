import React, { useState, useCallback, useEffect } from 'react'
import HeaderSocial from 'webapp/common/Header/HeaderSocial'
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import HomeMarketingSlider from "webapp/funding/component/showing/HeroMarketing";
import FooterOne from "webapp/common/Footer/FooterOne";
import {Link, useParams} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {getFundingDetail, currentFunding, dtoPath,updateFunding} from 'webapp/funding/reducer/funding.reducer'
import { Button, Grid, MenuItem, TextField } from '@material-ui/core';
const FundingUpdate = ({fundingId,title,content,hashtag, image,goalPrice}) =>{
    const dispatch = useDispatch()
console.log("0-0093939393939"+title)
    const param = useSelector(currentFunding)
    const dto = useSelector(dtoPath)
    const {update} = useParams()
    // useEffect(()=>{
    //     dispatch(getFundingDetail(update))
    // })
    const showDetailFunding = useSelector(state =>{
        console.log("state : " + JSON.stringify(state.showDetailFunding))
        return state.showDetailFunding
      })
    
    const [fundings, setUpdate] = useState({
        title: param?.title,
        content: param?.content,
        goalPrice: param?.goalPrice,
        hashtag : param?.hashtag
    })


const handleChange = e=>{
    setUpdate({
        [e.target.name]: [e.target.value]
    })
    dispatch(updateFunding(param?.fundingId,fundings))
}
const fileChange = useCallback(e=>{
    e.preventDefatult()
    const formData = new FormData()
    const update = {
        
    }
})
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
          <textarea className="form-control" placeholder={fundingId} rows="1" style={{color:"black"}}value={fundings.fundingId} name="fundingId" readOnly></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 제목 </label>
          <textarea className="form-control" placeholder={title} rows="1" style={{color:"black"}}value={fundings.title} name="title"></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 내용 </label>
          <textarea className="form-control" placeholder={content} rows="3" style={{color:"black"}}value={fundings.content} name="content"></textarea> 
          </div>
          <div> 
          <label className="form-label"> * 목표금액 </label>
          <textarea className="form-control" placeholder={goalPrice} rows="1" style={{color:"black"}}value={fundings.goalPrice} name="goalPrice"></textarea> 
          </div>
          <div> 
          <Grid item sm ={3}>
                <TextField
                select
                label="Select Hashtag"
                value={fundings.hashtag}
                placeholder={param?.hashtag}
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