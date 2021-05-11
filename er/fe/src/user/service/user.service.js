import axios from 'axios'

const findAll = () => axios.get("http://localhost:8080/users/findAll")
const signup = () => axios.post("http://localhost:8080/users/signup")
const signin =() => axios.get("http://localhost:8080/users/signin")
export default {findAll, signup, signin}