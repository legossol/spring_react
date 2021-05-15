import axios from 'axios'


const findAll=() =>{
    return axios.get("http://localhost:8080/item/list")
}
const itemRegister = (register) =>{
    axios({
        url: `http://localhost:8080/item/register`,
        method: 'post',
        headers:{ 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..'},
        date: register
    })
}
export default {findAll, itemRegister}