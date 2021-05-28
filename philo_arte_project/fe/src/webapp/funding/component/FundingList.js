import React, { useEffect, useState } from 'react'
import {Link} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {deleteFunding, getFundingDetail,getFundingList,updateFunding} from 'webapp/funding/reducer/funding.reducer'
const FundingList = () =>{
  const pageResult= useSelector(state=>state.fundings.pageResult)

  const page = pageResult.page
  
  const dispatch = useDispatch()

  const fundings = useSelector(state =>{
    return state.fundings.pageResult.dtoList
  })
  const msg = useSelector(state =>{
    return state.fundings.msg
  })
  const selectContent = fundingId =>{
    dispatch(getFundingDetail(fundingId))
  }
  useEffect((e)=>{
    dispatch(getFundingList(page))
  },[page])

 


  const FundingPageList = () => {

    const {pageList, page, start, end, prev, next} = useSelector(state=>state.fundings.pageResult)

    const dispatch = useDispatch()

    const movePage = (page)=>{
        dispatch(getFundingList(page))
    }

    const listNum = pageList.map(i=><button key={i} onClick={()=>movePage(i)}>{i}</button>)

    return(
        <div>
        {prev ? <button onClick={()=>movePage(start-1)}>prev</button> : <></>}
        {listNum}
        {next ? <button onClick={()=>movePage(end+1)}>next</button> : <></>}
    </div>
    )
  }

  
  return (
    <>
        <h1>{msg}</h1>
    <div className="container">
    <h1>아 이 템 리 스 트</h1>
    <table style={{border:30}}>
      <thead style={{textAlign:'center'}}>
        <tr>
            <th>fundingId</th>
            <th>title</th>
            <th>content</th>
            <th>goalPrice</th>
            <th>등록일</th>
            <th>hashtag</th>
            <th>viewCnt</th>
        </tr>
      </thead>
      <tbody style={{textAlign:'center'}}>
        {fundings.map((funding, id) =>{
          return(
            <tr key={id}>
              <td>{funding.fundingId}</td>
              <td>{funding.title}</td>
              <td>{funding.content}</td>
              <td>{funding.goalPrice}</td>
              <td>{funding.moddate}</td>
              <td>{funding.hashtag}</td>
              <td>{funding.viewCnt}</td>
              <td onClick={()=>selectContent(funding.fundingId)}>상세 보기</td>
              <button onClick={()=>dispatch(updateFunding(funding.fundingId))}>수정하기</button>
              <button onClick={()=>dispatch(deleteFunding(funding.fundingId))}>삭제하기</button>
            </tr>
          )
        })}
      </tbody>
      </table>
      <input type="text" placeholder="Philo-Arte 통합 검색"></input>
      <button>검색하기</button>
      <Link to={"/funding/register"}>
            <button>펀딩 등록하기</button>
      </Link>
      </div>
      <div style={{display:"flex",justifyContent:"center"}}>
      {FundingPageList()}
      </div>
    </>

       

    
  );
};


export default FundingList