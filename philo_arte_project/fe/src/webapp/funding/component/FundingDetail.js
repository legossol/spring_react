import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import {getFundingDetail,deleteFunding} from 'webapp/funding/reducer/funding.reducer'
import {Link} from 'react-router-dom'
const FundingDetail = () =>{
    const fundings = useSelector(state =>{
        console.log("funding detail state : " + JSON.stringify(state.fundings))
        return state.fundings
      })
      const dispatch = useDispatch()
      useEffect(()=>{
        dispatch(getFundingDetail())
      },[])
        return ( 
            <>
            <div className="container">
            <h1>펀 딩 아 이 템 디 테 일 페 이 지</h1>
        
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
                      
                    </tr>
                  )
                })}
              </tbody>
            
                
              </table>
              <Link to ={"/funding/update"}><button>수정하기 페이지로 가기</button></Link>
                      <button onClick={()=>dispatch(deleteFunding(fundings.fundingId))}>삭제하기</button>
            
               
              </div>
     
            
            </>
        )
}
export default FundingDetail