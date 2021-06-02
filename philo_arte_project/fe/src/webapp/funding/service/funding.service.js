import axios from 'axios'
import { useHistory } from 'react-router-dom'

const getList=(page) =>{
    return axios.get("http://localhost:8080/funding/list?page=" +page)
}
// const fundingRegister = (files) =>{
//     axios({
//         url: ("http://localhost:8080/funding/totalregister"+files),
//         method: 'POST',
//         headers:{ 'Content-Type': "multipart/form-data"},
//         data: files,
//     })
// }
const fundingRegister = (data) =>{
    return axios.post("http://localhost:8080/funding/register", data)
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
const deleteFunding = (funding) =>{
    // e.preventDefault()
    const del = window.confirm("글 삭제를 진행 하시겠습니까?")
    if(del){
    axios({
        url: `http://localhost:8080/funding/${funding}`,
        method:'DELETE'
    }).then(res =>{
        alert("삭제 완료")
    }).catch(err =>{
        alert("삭제과정에서 에러 발생" +err)
    })}
}
const fileUpload = (formData) => axios.post(`http://localhost:8080/funding_file/upload_file`,formData,
    {headers:{ "Content-Type": "multipart/form-data"}})

const searchSomething = (index)=>{
    return axios.get("http://localhost:8080/funding/list/search")
}
// const getFiles = ()
export default {getList, fundingRegister,showDetail,deleteFunding,fundingUpdate,searchSomething,fileUpload}