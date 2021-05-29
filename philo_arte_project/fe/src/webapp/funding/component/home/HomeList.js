import React, { useEffect, useState } from "react";
import parse from "html-react-parser";
import LoadScript from "webapp/common/helpers/LoadScript";
import ItemHandle from "./ItemHandle";
import { currentFunding } from "webapp/funding/reducer/funding.reducer";
import { useSelector } from "react-redux";


const HomeList = ({ title, tagline, backfont,data, hashtag,dash, dashColor, id }) => {

  LoadScript("js/portfolio/portfolio-grid.js");
    
//   const {hash , setHash} = useState(hashtags)

//   const filterButton = hashtags.map((hashtag, i) => {
//     return (<>
//       <div className="lay-button">
//         <button key={i} onClick={(e)=> setHash(e.target.value)}>{hashtag}</button>
//       </div>
//     </>)
//   })
    
  const totalList = data.map( (funding, i) => {
      console.log("totlaList 진입 : ")
    return (
      <ItemHandle 
        key={i}
        fundingId={funding.fundingId}
        title={funding.title}
        hashtag={funding.hashtag}
      />
    )});

  return (
    <section id="portfolio" className="pt-0 pb-0 ">
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
      </div>
      <div className="container-fluid remove-padding">
          <div className="col-md-12">
                  {/* {filterButton} */}
            <div id="portfolio-gallery" className="cbp">
                  {totalList}
            </div>
          </div>
        </div>

    </section>
  );
};

export default HomeList;