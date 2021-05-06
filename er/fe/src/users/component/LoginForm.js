import React, { useState, useEffect, useCallback} from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";

const LoginForm = (props) =>{
    console.log("logIn form 진입:",JSON.stringify(props))
    const tryLogin ={username:'',password:''}
    const [login, setLogin] = useState([]);
    const { username, password } = login

    // const handleChange = useCallback( e => {
    //     const {name, value} = e.target;
    //     setLogin({...login, [name] : value});
    // },[login]); 
    const handleChange = e =>{
        setLogin({
            [e.target.name]: e.target.value
        });
    }

    // const inputIdPassword = () =>{
    //     axios
    //         .get(`http://localhost:8080/users/login/${localStorage.getItem('username')}/${localStorage.getItem('password')}`)
    //         .then((res) => {
    //             console.log("inputidpassword들어옴")
    //             setLogin({
    //                 ...login,
    //                 username: res.data.username,
    //                 password: res.data.password
                    
    //             })
    //             console.log("inputidpassword 에러로 들어옴")
    //         })
            
    //         .catch((err) => console.log(err));
    // }
    
    const handleSubmit = useCallback(e => {
        e.preventDefault();
        if(login.username  || login.password){
        axios.post(`http://localhost:8080/users/login/`,{
            username,
            password    
        })
            .then((res) => {
                console.log("아디비번같음 확인",res)
                window.location ="/login"
            })
            .catch((err) => {
            alert(err)
            console.log("아이디 비번이 같지 않음")
        })
    }
    },[
        username,
        password
    ]);

    // useEffect(() => {
    //     inputIdPassword();
    // }, []);


    return(
            <form onSubmit={handleSubmit}>
                <div>
                    <label>아이디</label>
                    <input type="text" value={username} name="username" placeholder="ID"onChange={handleChange}/>
                    <label>비밀번호</label>
                    <input type="text" value={password} name="password" placeholder="Password"onChange={handleChange}/>
                </div>
               
               
                <div>
                    <input type="checkbox" name="keepLogin"/>
                    <label><span>로그인 상태 유지</span></label>

                </div>
                <button  type="submit">로그인</button>
                <Link to={`/ShowAllUser`}><button>Cancel</button> </Link>
            </form >
       
    )
}
export default LoginForm