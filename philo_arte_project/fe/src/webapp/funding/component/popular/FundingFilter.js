import React from "react";
import { useSelector } from "react-redux";

const PortfolioFilter = ({ classes, hashtag }) => {
  const funding = useSelector(state =>{
    return state.fundings.dtoList
  })
  // const filterHashtag = hashtag =>{
  //   funding.hashtag == hashtag


    // return funding.filter((el) =>
    // el.toLowerCase.indexOf(hashtag.toLowerCase)) > -1
  
  return(
  <div className="row mt-50">
    <div className="col-md-12">
      <div
        id="portfolio-gallery-filter"
        className={"cbp-l-filters-alignCenter text-sm-center " + classes}
      >
        <div
          data-filter="*"
          className="cbp-filter-item-active cbp-filter-item dark"
        >
          모든 펀딩
        </div>

        


        {hashtag.map((item, i) => {
          
          console.log(item.replace(/\s+/g, "-").toLowerCase())
          console.log(item.charAt(0).toUpperCase() + item.slice(1))
          return(
          <div
            key={i}
            data-filter={`.${item.replace(/\s+/g, "-").toLowerCase()}`}
            className="cbp-filter-item"
          >


            
            {item.charAt(0).toUpperCase() + item.slice(1)}
          </div>
  
        )
        }
        )
        }






      </div>
    </div>
  </div>
);
}
export default PortfolioFilter;