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
const deleteItem = (e) =>{
    e.preventDefault()
    const del = window.confirm("글 삭제를 진행 하시겠습니까?")
    if(del){
    axios({
        url: URL+'itemNo',
        method:'DELETE',
        headers:{'Content-Type':'application/json','Authorization': 'Bearer '+localStorage.getItem("token")},

    }).then(res =>{
        alert("삭제 완료")
        localStorage.removeItem("deleeted Item")
        localStorage.removeItem("token")
        useHistory.push('/')
    }).catch(err =>{
        alert("삭제과정에서 에러 발생" +err)
    })}
}
export default {findAll, itemRegister,deleteItem}