import React, {useState} from "react";
import { useSelector , useDispatch} from "react-redux";
import {Link, useHistory} from 'react-router-dom'
import { getFundingDetail, updateFunding ,getFundingList, currentFunding} from "webapp/funding/reducer/funding.reducer";
import readFunding from "webapp/funding/component/FundingDetail"
const ItemHandle = ({  id,data, title, hashtag, fundingId }) => {
    const dispatch = useDispatch();
    console.log("id는 무엇이냐? : " + data )
    const postIdToDetail = useSelector(state =>{
        return state.fundings.pageResult
    })
    // const fId = data.fundigId
    const moveDetail = (fundingId)=>{
        dispatch(getFundingDetail(fundingId))
        console.log("data =========="+data)
        console.log("fId =======" + fundingId)
    }
    return(
    
   
      <div className="col-md-3 mfp-iframe-holder " >
           <Link to ={`/funding/read/${fundingId}`}>
        
      <div className="portfolio-item"onClick={moveDetail(fundingId)}>
          
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