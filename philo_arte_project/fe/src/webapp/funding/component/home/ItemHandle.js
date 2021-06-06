import React, {useEffect, useState} from "react";
import { useSelector , useDispatch} from "react-redux";
import {Link, useHistory} from 'react-router-dom'
import { getFundingDetail, currentFunding, dtoPath} from "webapp/funding/reducer/funding.reducer";
import readFunding from "webapp/funding/component/FundingDetail"
import { FundingDetail } from "webapp/funding";
const ItemHandle = ({ title, hashtag, fundingId ,image}) => {
  
    const dispatch = useDispatch()
    const [list , setList] =useState({});
    const param = useSelector(currentFunding)
    const selectContent = fundingId =>{
        dispatch(getFundingDetail(fundingId))
      }


    return(
      <div className="col-md-3 mfp-iframe-holder " >
             <Link to ={`/funding/read/${fundingId}`} onClick={async()=>selectContent(fundingId)}>
          <div className="portfolio-item">
          <img src={image.map(img =>(`http://localhost:8080/funding_file/display?fileName=${img.uuid}_${img.fname}`))[0]} style={{height:"80%", width:"80%"}}/>
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
