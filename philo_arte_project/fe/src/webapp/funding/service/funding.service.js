import axios from 'axios'
import { useSelector } from 'react-redux'
import { useHistory } from 'react-router-dom'

const getList=(page) =>{
    return axios.get("http://localhost:8080/funding/list?page=" +page)
}
const fundingRegister = (files) =>{
    axios({
        url: ("http://localhost:8080/funding/totalregister"+FormData),
        method: 'POST',
        headers:{ 'Content-Type': "multipart/form-data", 'Authorization': 'JWT fefege..'},
        data: files,
    })
}

const showDetail =(fundingId)=>{
    console.log(`디테일보기 서비스 아이템 넘버 : ${fundingId}`)
    return axios.get(`http://localhost:8080/funding/${fundingId}`)
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
        localStorage.removeFunding("deleted Funding")
        // localStorage.removeFunding("token")
        useHistory.push('funding/list')
    }).catch(err =>{
        alert("삭제과정에서 에러 발생" +err)
    })}
}
const searchSomething = (index)=>{
    return axios.get("http://localhost:8080/funding/list/search")
}
// const getFiles = ()
export default {getList, fundingRegister,showDetail,deleteFunding,fundingUpdate,searchSomething}