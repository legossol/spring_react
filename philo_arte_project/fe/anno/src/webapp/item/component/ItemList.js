import React, { useEffect, useState } from 'react'
import {Link} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {getItemList} from '../reducer/item.reducer'

const ItemList = () =>{
  const items = useSelector(state =>{
    console.log("state : " + JSON.stringify(state.items))
    return state.items
  })
  const dispatch = useDispatch()
  useEffect(()=>{
    dispatch(getItemList())
  },[])
    return (
        <>
        <div className="container">
        <h1>아 이 템 리 스 트</h1>
        <table style={{border:10}}>
          <thead>
            <tr>
                <th>itemId</th>
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
            {items.map((item, id) =>{
              return(
                <tr key={id}>
                  <td>{item.itemId}</td>
                  <td>{item.title}</td>
                  <td>{item.writer}</td>
                  <td>{item.content}</td>
                  <td>{item.goalPrice}</td>
                  <td>{item.viewCnt}</td>
                  <td>{item.regDate}</td>
                  <td>{item.editDate}</td>
                  <td>{item.likeCnt}</td>
                  <td>{item.dislikeCnt}</td>
                  <td>{item.likeCheck}</td>
                </tr>
              )
            })}
          </tbody>
        
            
          </table>
          <Link to={"/item/register"}>
                <button>펀딩 등록하기</button>
            </Link>
            <button>삭제하기</button>
          </div>
 
        
        </>
    )
}
export default ItemList