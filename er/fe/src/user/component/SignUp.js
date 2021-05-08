import axios from 'axios';
import React, { useState, useCallback} from 'react';
import { useSelector } from 'react-redux';
import 'user/style/SignUp.css';
const SignUp = () => {
    const users = useSelector(state => {
        console.log("state: " + JSON.stringify(state))
        return state.users
    });
    const registerUser = {id : '', password:'', email: '', name: ''}
    const [user, setUser] = useState(registerUser)
    const {id, password, email, name} = user
    const handleChange = useCallback(e =>{
        const {name, value} = e.target;
        setUser({...user,
        [name]: value
    },[user])
    })
    const handleSubmit = useCallback( e => {
        e.preventDefault();
        if(user.id &&user.password &&user.email &&user.name){
            axios.post('http://localhost:8080/users/signup',{id,password,email,name})
            .then(res =>{
                alert("회원등록 되었습니다", res)
                window.location = '/users/list'
            })
            .catch(err => console.log(err))}
            else{
                alert("모든 항목을 장성해주세요")
            }
    },[id,password,email,name])
    
    // const dispatch = useDispatch();
    // useEffect(() =>{
    //     alert(`signup. useEffect`)
    //     dispatch(getUserList());
    // },[]);
    
    

    return (
        <>
        <div className="container">
        <h1>사용자 등록</h1>
        <hr/>
        <form onSubmit={handleSubmit} method={"post"}></form>
        <label>ID : </label>
        <input type="text" name="ID" value={id} onChange={handleSubmit}></input>
        <label>PW : </label>
        <input type="text" name="password" value={password} onChange={handleSubmit}></input>
        <label>EMAIL : </label>
        <input type="text" name="password" value={email} onChange={handleSubmit}></input>
        <label>NAME : </label>
        <input type="text" name="password" value={name} onChange={handleSubmit}></input>

        <button type="submit" onClick={()=>handleChange}>Sign UP</button>
    </div>
        </>
    );
};
export default SignUp;