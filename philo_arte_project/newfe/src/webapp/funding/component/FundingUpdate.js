import React, { useState, useCallback } from 'react'
import {Link} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {updateFunding, deleteFunding,showFundingDetail} from 'webapp/funding/reducer/funding.reducer'
const FundingUpdate = () =>{
    const showDetailFunding = useSelector(state =>{
        console.log("state : " + JSON.stringify(state.showDetailFunding))
        return state.showDetailFunding
      })
    const dispatch = useDispatch()
    const [fundings, setUpdate] = useState({
        fundingId :"",
        title: "",
        writer: "",
        content: "",
        goalPrice: "",
        viewCnt: "",
        regDate: "",
        editDate: "",
        likeCnt:"",
        dislikeCnt:"",
    })


const handleChange = useCallback(e=>{
    const{wnatChange, value} =e.target;
    setUpdate({...fundings,
        [wnatChange] : value})
},[fundings])
    return(
        <>
        <h1> 펀 딩 업 데 이 트</h1>
        <form onSubmit={handleChange}>
            <table>
                <thead>
                    <tr>
                        <th>fundingId</th>
                        <td><input name='fundingId' value={fundings.fundingId}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>Title</th>
                        <td><input type='text'name='title' placeholder="수정하려는 타이틀을 입력하세요"value={fundings.title} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>Writer</th>
                        <td><input name='writer' value={fundings.writer}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>Content</th>
                        <td><input type='text' placeholder='컨텐츠의 내용을 수정하세요' name='content' value={fundings.content} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>GoalPrice</th>
                        <td><input type='number'name='goalPrice' placeholder='목표금액 재 설정' value={fundings.GoalPrice} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>ViewCnt</th>
                        <td><input name='viewCnt' value={fundings.viewCnt}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>등록일</th>
                        <td><input name='regdate' value={fundings.regDate}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>마지막 수정일</th>
                        <td><input name='editDate' value={fundings.editDate}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>좋아요 수</th>
                        <td><input name='likeCnt' value={fundings.likeCnt}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>싫어요 수</th>
                        <td><input name='dislikeCnt' value={fundings.dislikeCnt}readOnly></input></td>
                    </tr>
                    
                    
                    <td>
                        <Link to={"/funding/list"}><button type="submit" onClick={()=>dispatch(updateFunding(fundings.fundingId))}>수정 완료</button></Link>
                    </td>
                    <td>
                        <button type="submit" onClick={()=>dispatch(deleteFunding(fundings.fundingId))}>글 삭제</button>
                    </td>
                </thead>    
                
            </table>
            <div>
                <Link to={"/funding/list"}><button>나가기</button></Link>
            </div>
        </form>
        </>
    )
}
export default FundingUpdate