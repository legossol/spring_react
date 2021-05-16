import axios from 'axios'
import { useHistory } from 'react-router-dom'


const findAll=() =>{
    return axios.get("http://localhost:8080/item/list")
}
const itemRegister = (register) =>{
    axios({
        url: "http://localhost:8080/item/register",
        method: 'POST',
        headers:{ 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..'},
        data: register,
        
    })
}

const showDetail =(itemNo)=>{
    return axios.get(`http://localhost:8080/item/list/${itemNo}`)
}
const itemUpdate = id =>{
    // e.preventDefault()
    const  up = window.confirm("정보를 수정하시겠습니까?")
    if(up){
        axios({
            url: `http://localhost:8080/item/${id}`,
            method: 'put',
            // headers
            data:{}
        }).then(res =>{
            alert("수정되었습니다")
            useHistory.push('/list')
            window.location.reload()
        }).catch(err =>{
            alert(err)
        })
    }
}
const deleteItem = (id) =>{
    // e.preventDefault()
    const del = window.confirm("글 삭제를 진행 하시겠습니까?")
    if(del){
    axios({
        url: `http://localhost:8080/item/${id}`,
        method:'DELETE',
        // headers:{'Content-Type':'application/json','Authorization': 'JWT fefege..'},
        // 'Bearer '+localStorage.getItem("token")
    }).then(res =>{
        alert("삭제 완료")
        localStorage.removeItem("deleeted Item")
        // localStorage.removeItem("token")
        useHistory.push('/list')
    }).catch(err =>{
        alert("삭제과정에서 에러 발생" +err)
    })}
}

export default {findAll, itemRegister,showDetail,deleteItem,itemUpdate}