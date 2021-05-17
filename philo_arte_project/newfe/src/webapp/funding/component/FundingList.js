import React, { useEffect } from 'react'
import {Link} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {getFundingList, deleteFunding,getFundingDetail,updateFunding} from 'webapp/funding/reducer/funding.reducer'

const FundingList = () =>{
  const fundings = useSelector(state =>{
    console.log("state : " + JSON.stringify(state.fundings))
    return state.fundings
  })
  const dispatch = useDispatch()
  useEffect(()=>{
    dispatch(getFundingList())
  },[])
  
    return ( 
        <>
        
        <div className="container">
        <h1>아 이 템 리 스 트</h1>
        <table style={{border:30}} >
          <thead>
            <tr>
                <th>fundingId</th>
                <th>title</th>
                <th>writer</th>
                <th>content</th>
                <th>goalPrice</th>
                <th>viewCnt</th>
                <th>regDate</th>
                <th>editDate</th>
                <th>likeCnt</th>
                <th>dislikeCnt</th>
                <th>likeCheck</th>

            </tr>
          </thead>
          <tbody>
            {fundings.map((funding, id) =>{
              return(
                <tr key={id}>
                  <td>{funding.fundingId}</td>
                  <td>{funding.title}</td>
                  <td>{funding.writer}</td>
                  <td>{funding.content}</td>
                  <td>{funding.goalPrice}</td>
                  <td>{funding.viewCnt}</td>
                  <td>{funding.regDate}</td>
                  <td>{funding.editDate}</td>
                  <td>{funding.likeCnt}</td>
                  <td>{funding.dislikeCnt}</td>
                  <td>{funding.likeCheck}</td>
                  <Link to={`/funding/detail`}><button onClick={()=>dispatch(getFundingDetail(funding.fundingId))}>상세보기</button></Link>
                  <button onClick={()=>dispatch(updateFunding(funding.fundingId))}>수정하기</button>
                  <button onClick={()=>dispatch(deleteFunding(funding.fundingId))}>삭제하기</button>
                </tr>
              )
            })}
          </tbody>
        
            
          </table>
          <Link to={"/funding/register"}>
                <button>펀딩 등록하기</button>
          </Link>
           
          </div>
 
        
        </>
    )
}
export default FundingList