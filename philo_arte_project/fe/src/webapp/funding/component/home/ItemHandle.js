import React, {useEffect, useState} from "react";
import { useSelector , useDispatch} from "react-redux";
import {Link, useHistory} from 'react-router-dom'
import { getFundingDetail, updateFunding ,getFundingList, currentFunding, dududududududu} from "webapp/funding/reducer/funding.reducer";
import readFunding from "webapp/funding/component/FundingDetail"
import { FundingDetail } from "webapp/funding";
const ItemHandle = ({ title, hashtag, fundingId }) => {
    const param = useSelector(currentFunding)
    const param2= useSelector(dududududududu)
    const dispatch = useDispatch()
    const [list , setList] =useState({});
    
    const selectContent = fundingId =>{
        dispatch(getFundingDetail(fundingId))
      }
      console.log("itemhandle 의 파람!!!!!!!!!!!!!!!!!!!!!우니루야ㅏ진루ㅏ"+ JSON.stringify(list))
    
    return(
      <div className="col-md-3 mfp-iframe-holder " >
             <Link to ={`/funding/read/${fundingId}`} onClick={()=>selectContent(fundingId)}>
      <div className="portfolio-item">
          
        <img src='https://www.radiokorea.com/data/file/c_talk_pet/644496679_nXjx54Sc_4nnLaHCzm3n.jpg' />
        <div className="portfolio-info white-bg">
          <div className="centrize">
            <div className="v-center dark-color">
              <h3>{title}</h3>
              <p>{hashtag}</p>
            </div>
          </div>  
        </div>
        </div>
        </Link>
    </div>
   
  );
}

export default ItemHandle;
