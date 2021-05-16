import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import {getItemDetail,deleteItem} from '../reducer/item.reducer'
import {Link} from 'react-router-dom'
const ItemDetail = (e) =>{
    const items = useSelector(state =>{
        console.log("state : " + JSON.stringify(state.items))
        return state.items
      })
      const dispatch = useDispatch()
      useEffect(()=>{
        dispatch(getItemDetail())
      },[])
        return ( 
            <>
            <div className="container">
            <h1>펀 딩 아 이 템 디 테 일 페 이 지</h1>
        
            <table style={{border:30}} >
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
                      <Link to ={"/item/update"}><button>수정하기</button></Link>
                      <button onClick={()=>dispatch(deleteItem(item.itemId))}>삭제하기</button>
                    </tr>
                  )
                })}
              </tbody>
            
                
              </table>
              <Link to={"/item/register"}>
                    <button>펀딩 등록하기</button>
              </Link>
               
              </div>
     
            
            </>
        )
}
export default ItemDetail