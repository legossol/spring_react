import axios from 'axios'
import { useHistory } from 'react-router-dom'


const findAll=() =>{
    return axios.get("http://localhost:8080/funding/list")
}
const fundingRegister = (register) =>{
    axios({
        url: "http://localhost:8080/funding/register",
        method: 'POST',
        headers:{ 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..'},
        data: register,
        
    })
}

const showDetail =(fundingNo)=>{
    console.log(`디테일보기 서비스 아이템 넘버 : ${fundingNo}`)
    return axios.get(`http://localhost:8080/funding/list/${fundingNo}`)
}

const fundingUpdate = id =>{
    // e.preventDefault()
    const  up = window.confirm("정보를 수정하시겠습니까?")
    if(up){
        axios({
            url: `http://localhost:8080/funding/${id}`,
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
const deleteFunding = (id) =>{
    // e.preventDefault()
    const del = window.confirm("글 삭제를 진행 하시겠습니까?")
    if(del){
    axios({
        url: `http://localhost:8080/funding/${id}`,
        method:'DELETE',
        // headers:{'Content-Type':'application/json','Authorization': 'JWT fefege..'},
        // 'Bearer '+localStorage.getFunding("token")
    }).then(res =>{
        alert("삭제 완료")
        localStorage.removeFunding("deleeted Funding")
        // localStorage.removeFunding("token")
        useHistory.push('/list')
    }).catch(err =>{
        alert("삭제과정에서 에러 발생" +err)
    })}
}
const searchSomething = (index)=>{
    return axios.get("http://localhost:8080/funding/list/search")
}

export default {findAll, fundingRegister,showDetail,deleteFunding,fundingUpdate,searchSomething}