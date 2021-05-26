import React from "react";
import {useDispatch, useSelector} from 'react-redux'
import parse from "html-react-parser";
import PortfolioItem from "webapp/resume/component/Presentation/PortfolioItem";
import PortfolioFilter from "./PortfolioFilter";
import LoadScript from "../helpers/LoadScript";

const PortfolioOne = ({ title, tagline, backfont, data, filter, categories, classes, dash, dashColor }) => {
  LoadScript("js/portfolio/portfolio-grid.js");
  const fundings = useSelector(state =>{
    return state.fundings.pageResult.dtoList
  })
  const renderData = ()=>{
    return(
      <h1>
      {fundings.map((funding, id)=>{
        return <li key={id}>{funding.title}</li>
      })}
      </h1>
    )
  }
  return (
    <section id="portfolio" className={"pb-0 " + classes}>
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <div className="section-title text-center">
              <h2 className="cardo-font default-color" data-backfont={backfont}>
                {tagline}
              </h2>
              
              <h1>{renderData()}</h1>
              {dash === "show" ? <hr className={"center_line " + (dashColor === "dark" ? "dark-bg" : "default-bg")} /> : null}
            </div>
          </div>
        </div>
        {filter === true && Array.isArray(categories) ? (
          <PortfolioFilter categories={categories} classes="mb-80" />
        ) : null}
      </div>
      <div className="container-fluid remove-padding">
        <div className={"row " + (!filter ? "mt-80" : "")}>
          <div className="col-md-12">
            <div id="portfolio-gallery" className="cbp">
              {data
                .filter((v, i) => i < 8)
                .map((fundings, i) => (
                  <PortfolioItem
                    key={fundings.id}
                    title={fundings.title}
                    categories={fundings.categories}
                    image={fundings.image}
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
