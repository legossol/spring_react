import axios from 'axios'

const readData = () =>{
    return axios.get("http://localhost:8080/todo/pages")
}
export default {readData}