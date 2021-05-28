import React from "react";
import { useSelector } from "react-redux";
import {Link} from 'react-router-dom'

const Itemhandle = ({ id, image, title, hashtag }) => {

  console.log("hashtag", hashtag)

    const fundings = useSelector(state =>{
        console.log("portfolio One 진입:" + JSON.stringify(state.fundings.pageResult.dtoList))
        return state.fundings.dtoList
      })
    return(
  <div
    className={
      "cbp-item col-md-3 col-sm-6 " +hashtag
      // hashtag.join(',').replace(/\s+/g, "-").replace(/,/g, ' ').toLowerCase().split()
    }
  >
    <div className="portfolio-item">
      <Link to={`/funding/${id}`}>
        <img src='https://www.radiokorea.com/data/file/c_talk_pet/644496679_nXjx54Sc_4nnLaHCzm3n.jpg' />
        <div className="portfolio-info white-bg">
          <div className="centrize">
            <div className="v-center dark-color">
              <h3>{title}</h3>
              <p>{hashtag}</p>
            </div>
          </div>
        </div>
      </Link>
    </div>
  </div>
);
}
export default Itemhandle;
