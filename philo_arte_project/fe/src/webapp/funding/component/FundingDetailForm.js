import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useParams } from 'react-router-dom';
import { currentFunding, getFundingDetail } from '../reducer/funding.reducer';

const FundingDetailForm = (key, title) =>{

console.log("key ======"+ key)
console.log("title ======"+ title)
const dispatch = useDispatch()
useEffect(()=>{})
 
    return(
        <>
         <div className="container">
              <div className="card col-md-8 offset-md-3">
                  
                <div> 
                <label className="form-label"> * NO </label>
                <textarea className="form-control"  rows="1" style={{color:"black"}} value={key} name="key" readOnly></textarea> 
                </div>
                <div> 
                <label className="form-label"> * title </label>
                <textarea className="form-control"  rows="1" style={{color:"black"}} value={title} name="title" readOnly></textarea> 
                </div>
                </div>
              </div>
        </>

    )
}
export default FundingDetailForm