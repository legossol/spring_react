import React from 'react';
import {Link} from 'react-router-dom'
const ItemRegister = () =>{
    return(
        <>
        <h1>아 이 템 등 록 하 기</h1>
        <form>
            
            <label>title</label>
            <input/>
            <label>content</label>
            <input/>
            <label>목표금액</label>
            <input/>  
            <Link to={'/category/item/list'}><button type='submit'>등록</button></Link>
            <Link to={'/category/item/list'}><button>취소</button></Link>
            

        </form>
        </>
    )
}

export default ItemRegister