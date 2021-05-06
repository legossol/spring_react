import React, { useState, useEffect, useCallback} from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";
import 'user/'
const Login = () =>{
   
    return(
      <div className="container">
      <h1>사용자 로그인</h1>
      <hr/>
      <label>ID : </label>
        <input></input>
      <label>PW : </label>
        <input></input>
  </div>
       
    )
}
export default Login;