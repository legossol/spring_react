import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import {getFundingDetail,deleteFunding, currentFunding, dududududududu} from 'webapp/funding/reducer/funding.reducer'
import {Link, useParams} from 'react-router-dom'
import HeaderSocial from 'webapp/common/Header/HeaderSocial'
import HomeMarketingSlider from "webapp/funding/component/showing/HeroMarketing";
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import FooterOne from "webapp/common/Footer/FooterOne";
import FundingList from './FundingList'
import FundingDetailForm from './FundingDetailForm'
import { Grid, makeStyles } from '@material-ui/core'

const FundingDetail = () =>{
  const dispatch = useDispatch()
  const {read} = useParams()
  const param = useSelector(currentFunding)
console.log("param은 이것입니다::::::::::" + JSON.stringify(param))
  useEffect(()=>{
    dispatch(getFundingDetail(read))
  },[])
console.log("param은느느느느느"+JSON.stringify(param))
console.log("param.fundingId ==" + param?.fundingId)










  const useStyles = makeStyles((theme)=> ({
    root: {
      flexGrow: 1,
    },
    paper: {
      padding: theme.spacing(2),
      textAlign: 'center',
      color: theme.palette.text.secondary,
    },
  }));
  
  const classes = useStyles();
        return ( 
            <>
             <HeaderSocial data={dataNavbar} />
              <HomeMarketingSlider/>
              <Grid item xs={12}>
              
        <div className="container">
        
        <div className="card col-md-8 offset-md-3">
            
          <div> 
          <label className="form-label"> * NO </label>
          <textarea className="form-control"  rows="1" style={{color:"black"}} value={param?.fundingId} name="fundingId" readOnly></textarea> 
          </div>
          <div> 
          <label className="form-label"> * title </label>
          <textarea className="form-control"  rows="1" style={{color:"black"}} value={param?.title} name="title" readOnly></textarea> 
          </div>
          
            {param?.fundingFiles.map((funding,i)=>{
              return (
                <div>
                  <img src={`http://localhost:8080/funding_file/display/da12b70b-6a65-423a-a396-91abe1b3cf57_testGit.png`}/>
                  {funding.fname}
                </div>
              )
            })}
         
          
          </div>
        </div>
              {/* <FundingDetailForm
                id ={param.fundingId}
                title ={param.title}
                /> */}

                {/* {postData} */}
              </Grid>
              <FooterOne />
            </>
            
        )
};
export default FundingDetail

