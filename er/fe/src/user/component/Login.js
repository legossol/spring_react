import React, { useState, useEffect, useCallback} from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";
import 'user/'
const Login = () =>{
   
  const initUser = {username:'', password:''}

  const [user, setUser] = useState(initUser);
  
  const {username, password} = user

  const handleChange = useCallback ( e => {
      const {name, value} = e.target;
      setUser({
          ...user,[name] : value
          
      })
      console.log(value)
  }, [user])
 
  
  const handleSubmit = useCallback ( e =>{
      e.preventDefault();
      
      if(user.username && user.password){
          console.log("ID: " , username)
          console.log("Password: " , password)
          axios.post(`http://localhost:8080/users/signin`,{username, password})
          
          .then(res => {
              console.log(user.username, user.password)
              alert("no, username"+JSON.stringify(res.data) )
              sessionStorage.setItem('username', username)
              console.log("setSessionStorage: " ,  sessionStorage.getItem('username') )
              console.log("res.data.message: " ,  res.data.message )
              alert("로그인이 되었습니다");
              window.location = '/'
              
          })
          .catch(err => 
              alert("회원 정보가 맞지 않습니다.", err)
              )
      }
      else{
          alert('모든항목을 작성해 주세요')
      }
  },[username,password])

  useEffect(() => {
      axios.get('http://localhost:8080/users/list')
      .then(res => console.log("useEffect: ",res))
      .catch()
  },[])
 
  return ( <>
  <form onSubmit={handleSubmit} method={"post"}>

          <label>아이디</label>
          <input className="u-full-width" type="text" name="username" value={username} onChange={handleChange}/>
          <label>비밀번호</label>
          <input className="u-full-width" type="password" name="password" value={password} onChange={handleChange} />
          
          <button className="button-primary" type="submit" onClick={()=>handleSubmit}>Login</button><br></br>
          <Link to={'/signup'}><button className="button-primary" >SignUp</button></Link>
      </form>

  </> );
}

export default Login;