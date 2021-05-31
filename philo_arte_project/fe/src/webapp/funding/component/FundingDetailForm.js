import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { currentFunding } from '../reducer/funding.reducer';

const FundingDetailForm = ({title, id}) =>{
    const dispatch = useDispatch();
    const param = useSelector(currentFunding)
    console.log("idsmsmsmsmsmsm"+id)
    return(

        <div className="container">
        
    <div className="card col-md-8 offset-md-3">
        
      <div> 
      <label className="form-label"> * NO </label>
      <textarea className="form-control"  rows="1" style={{color:"black"}} value={id} name="id" readOnly></textarea> 
      </div>
      <div> 
      <label className="form-label"> * title </label>
      <textarea className="form-control"  rows="1" style={{color:"black"}} value={title} name="title" readOnly></textarea> 
      </div>
      </div>
    </div>

)};
export default FundingDetailForm

// import React, { useEffect, useState } from 'react';
// import { useDispatch, useSelector } from 'react-redux';
// import { useParams } from 'react-router-dom';
// import { currentFunding, getFundingDetail } from '../reducer/funding.reducer';

// const FundingDetailForm = (key) =>{

// console.log("key ======"+ key)

// const dispatch = useDispatch()
// const read = () =>{
//     dispatch(getFundingDetail(key))
// }
// useEffect(()=>{
//     read
// },[])
 
//     return(
//         <>
//          <div className="container">
//               <div className="card col-md-8 offset-md-3">
                  
//                 <div> 
//                 <label className="form-label"> * NO </label>
//                 <textarea className="form-control"  rows="1" style={{color:"black"}} value={key.fundingId} name="key" readOnly></textarea> 
//                 </div>
//                 <div> 
//                 <label className="form-label"> * title </label>
//                 <textarea className="form-control"  rows="1" style={{color:"black"}} value={key.title} name="title" readOnly></textarea> 
//                 </div>
//                 </div>
//               </div>
//         </>

//     )
// }
// export default FundingDetailForm