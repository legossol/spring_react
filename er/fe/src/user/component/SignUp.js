import React from 'react';
import {Link} from 'react-router-dom';
import { useCallback, useState } from "react";
import { useDispatch, useSelector } from 'react-redux';
import { signup} from '../reducer/user.reducer'
import 'user/style/SignUp.css';

const SignUp = () => {
    const dispatch = useDispatch();

    const [user, setUser] = useState({
        username : "",
        password : "",
        name: "",
        email: ""
    });
    const onCreate = e =>{
        e.preventDefault();
        if(user){
            const newUser = { username: user.username, password: user.password, name: user.name, email: user.email };
            dispatch(signup(newUser));
            setUser("");
        }else{
            console.log("모든항목을 작성하세요")
        }
    }
    


    return ( <>
        <form onSubmit={onCreate} action=''>
            
            <label>아이디</label>
            <input className="u-full-width" type="text" name="username" value={user.username} onChange={e => setUser(e.target.value)} />
            <label>비밀번호</label>
            <input className="u-full-width" type="password" name="password" value={user.password} onChange={e => setUser(e.target.value)} />
            <label>이름</label>
            <input className="u-full-width" type="text" name="uname" value={user.uname} onChange={e => setUser(e.target.value)} />
            <label>이메일</label>
            <input className="u-full-width" type="email" name="email" value={user.email} onChange={e => setUser(e.target.value)} />  
            <button type='submit'>회원가입</button>
            <Link to={'/'}><button>취소</button></Link>
            

        </form>
    </> );
}
 
export default SignUp;