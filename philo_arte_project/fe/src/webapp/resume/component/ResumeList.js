import React, { useEffect, useState } from "react";
import parse from "html-react-parser";
import LoadScript from "webapp/common/helpers/LoadScript";

import ResumeItemList from "./ResumeItemList";
import ResumeListFilter from "./ResumeListFilter";
import { useDispatch } from "react-redux";
import { listResume } from "../reducer/resume.reduce";

const ResumeList = ({
  data,
  title,
  tagline,
  backfont,
  filter,
  categories,
  classes
}) => {
  LoadScript("js/portfolio/portfolio-grid.js");
  const dispatch = useDispatch()
  useEffect(()=>{
    
    dispatch(listResume());
    alert("리스트 가져와랏: " , JSON.stringify(data))

  })

  return (<>
    <section id="portfolio" className={"pb-0 " + classes}>
      <div className="container">
        {title ? (
          <div className="row">
            <div className="col-md-12">
              <div className="section-title text-center">
                <h2
                  className="cardo-font default-color"
                  data-backfont={backfont || "Works"}
                >
                  {tagline}
                </h2>
                <h1>{title && parse(title)}</h1>
                <hr className="center_line dark-bg" />
              </div>
            </div>
          </div>
        ) : null}
        {filter === true && Array.isArray(categories) ? (
          <ResumeListFilter categories={categories} classes="mb-80" />
        ) : null}
      </div>
      <div className="container-fluid remove-padding">
        <div className="row">
          <div className="col-md-12">
            <div id="portfolio-gallery" className="cbp">
              {data.map((resume, i) => (
                <ResumeItemList
                  key={resume.id}
                  index={i}
                  title={resume.title}
                  categories={resume.category}
                  image={resume.mainPic}
                />
              ))}
            </div>
          </div>
        </div>
      </div>
    </section>
  </>);
};

export default ResumeList;
