import React, {useState} from "react";
import { useSelector , useDispatch} from "react-redux";
import {Link, useHistory} from 'react-router-dom'
import { getFundingDetail, updateFunding ,getFundingList} from "webapp/funding/reducer/funding.reducer";
import readFunding from "webapp/funding/component/FundingDetail"
const ItemHandle = ({ id, image, title, hashtag }) => {
    const dispatch = useDispatch();
    const history = useHistory();
    const selectContent = id =>{
        dispatch(getFundingDetail(id))
      }
    
    return(
    

      <div className="col-md-3 mfp-iframe-holder " >
          <Link to ="/funding/read" onChange={selectContent}>
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
