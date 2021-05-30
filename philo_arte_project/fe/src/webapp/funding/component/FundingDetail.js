import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import {getFundingDetail,deleteFunding, currentFunding} from 'webapp/funding/reducer/funding.reducer'
import {Link, useParams} from 'react-router-dom'
import HeaderSocial from 'webapp/common/Header/HeaderSocial'
import HomeMarketingSlider from "webapp/funding/component/showing/HeroMarketing";
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import FooterOne from "webapp/common/Footer/FooterOne";
import FundingList from './FundingList'
import FundingDetailForm from './FundingDetailForm'

const FundingDetail = () =>{
    //  const datas = useSelector(currentFunding)
     const datas = useSelector(state => state.fundings.pageResult.dtoList)
     console.log(JSON.stringify("json datas====="+JSON.stringify(datas)))
     const {read} = useParams();
     
     const postData = () =>datas.map(data=>{
      console.log("key ======"+ data.id)
      console.log("title ======"+ data.title)
       return <FundingDetailForm
                key={data.id}
                title = {data.title}/>
     })
     console.log("postData ====="+ postData(read))
     const dispatch = useDispatch()
     useEffect((e)=>{
       dispatch(getFundingDetail(read))
     })
        return ( 
            <>
             <HeaderSocial data={dataNavbar} />
              <HomeMarketingSlider/>
              <div>
                {postData()}
              </div>
              {/* <FundingDetailForm */}

              <FooterOne />
            </>
            
        )
};
export default FundingDetail