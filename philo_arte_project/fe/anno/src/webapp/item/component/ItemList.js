import React, { useEffect, useState } from 'react'
import {Link} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
// import {getItemList} from '../reducer/item.reducer'

const ItemList = () =>{
  const [items, setItems] = useState([])

    return (
        <>
        <div>
        <h1>아 이 템 리 스 트</h1>
        <table>
          <thead>
            <tr>
                <th>itemId</th>
                <th>title</th>
                <th>writer</th>
                <th>content</th>
                <th>goalPrice</th>
                <th>viewCnt</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, id) =>{
              return(
                <tr key={id}>
                  <td>{items.itemId}</td>
                  <td>{items.title}</td>
                  <td>{items.writer}</td>
                  <td>{items.content}</td>
                  <td>{items.goalPrice}</td>
                  <td>{items.viewCnt}</td>
                </tr>
              )
            })}
          </tbody>
        
            <Link to={"/category/item/register"}>
                <button>펀딩 등록하기</button>
            </Link>
            <button>삭제하기</button>
          </table>
          </div>
 
        
        </>
    )
}
export default ItemList