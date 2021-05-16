import React, { useState, useCallback } from 'react'
import {Link} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {updateItem, deleteItem,showItemDetail} from '../reducer/item.reducer'
const ItemUpdate = () =>{
    const showDetailItem = useSelector(state =>{
        console.log("state : " + JSON.stringify(state.showDetailItem))
        return state.showDetailItem
      })
    const dispatch = useDispatch()
    const [items, setUpdate] = useState({
        itemId :"",
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
    setUpdate({...items,
        [wnatChange] : value})
},[items])
    return(
        <>
        <h1> 펀 딩 업 데 이 트</h1>
        <form onSubmit={handleChange}>
            <table>
                <thead>
                    <tr>
                        <th>itemId</th>
                        <td><input name='itemId' value={items.itemId}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>Title</th>
                        <td><input type='text'name='title' placeholder="수정하려는 타이틀을 입력하세요"value={items.title} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>Writer</th>
                        <td><input name='writer' value={items.writer}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>Content</th>
                        <td><input type='text' placeholder='컨텐츠의 내용을 수정하세요' name='content' value={items.content} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>GoalPrice</th>
                        <td><input type='number'name='goalPrice' placeholder='목표금액 재 설정' value={items.GoalPrice} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>ViewCnt</th>
                        <td><input name='viewCnt' value={items.viewCnt}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>등록일</th>
                        <td><input name='regdate' value={items.regDate}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>마지막 수정일</th>
                        <td><input name='editDate' value={items.editDate}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>좋아요 수</th>
                        <td><input name='likeCnt' value={items.likeCnt}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>싫어요 수</th>
                        <td><input name='dislikeCnt' value={items.dislikeCnt}readOnly></input></td>
                    </tr>
                    
                    
                    <td>
                        <Link to={"/item/list"}><button type="submit" onClick={()=>dispatch(updateItem(items.itemId))}>수정 완료</button></Link>
                    </td>
                    <td>
                        <button type="submit" onClick={()=>dispatch(deleteItem(items.itemId))}>글 삭제</button>
                    </td>
                </thead>    
                
            </table>
            <div>
                <Link to={"/item/list"}><button>나가기</button></Link>
            </div>
        </form>
        </>
    )
}
export default ItemUpdate