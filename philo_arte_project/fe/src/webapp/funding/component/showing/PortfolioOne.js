import React, { useEffect } from "react";
import parse from "html-react-parser";
import PortfolioItem from "webapp/resume/component/Presentation/PortfolioItem";
import PortfolioFilter from "webapp/common/Portfolio/PortfolioFilter";
import LoadScript from "../../../common/helpers/LoadScript";
import { useDispatch, useSelector } from "react-redux";
import fundingList from "../FundingList"
import FundingFilter from "../popular/FundingFilter"
import { currentFunding, getFundingList } from "webapp/funding/reducer/funding.reducer";
import Itemhandle from "../popular/Itemhandle"
import { FundingList } from "webapp/funding/";



const PortfolioOne = ({ tagline, backfont, filter, classes, dash, dashColor, hashtag,title,data}) => {
  LoadScript("js/portfolio/portfolio-grid.js");
 
  // const fundings = useSelector(state =>{
  //   console.log("portfolio One 진입:" + JSON.stringify(state.fundings.pageResult.dtoList))
  //   return state.fundings.pageResult.dtoList
  // })
  // const dispatch = useDispatch()
  // useEffect(() => {dispatch(getFundingList())},[])
  
 
  return (
    <section id="portfolio" className={"pb-0 " + classes}>
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <div className="section-title text-center">
              <h2 className="cardo-font default-color" data-backfont={backfont}>
                {tagline}
              </h2>
              
              <h1>{title && parse(title)}</h1>
              {dash === "show" ? <hr className={"center_line " + (dashColor === "dark" ? "dark-bg" : "default-bg")} /> : null}
            </div>
          </div>
        </div>
        {filter === true && Array.isArray(hashtag) ? (
          <FundingFilter hashtag={hashtag} classes="mb-80" />
        ) : null}
      </div>
      <div className="container-fluid remove-padding">
        <div className={"row " + (!filter ? "mt-80" : "")}>
          <div className="col-md-12">
            <div id="portfolio-gallery" className="cbp">
              {data
                .map((fundings, i) => (
                  <Itemhandle
                    key={fundings.fundingId}
                    id={fundings.fundingId}
                    title={fundings.title}
                    image={fundings.image}
                    hashtag={hashtag}
                  />
                ))}
                
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default PortfolioOne;
