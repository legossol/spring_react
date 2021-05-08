import React from 'react';
import { useSelector } from 'react-redux';
import 'user/style/SignUp.css';
const SignUp = () => {
    const users = useSelector(state => {
        console.log("state: " + JSON.stringify(state))
        return state.users
    });
    const dispatch = useDispatch();
    useEffect(() =>{
        alert(`signup. useEffect`)
        dispatch(getUserList());
    },[]);
    
    

    return (
        <>
        <div className="container">
        <h1>사용자 등록</h1>
        <hr/>
        <label>ID : </label>
        <input type="text" name="ID" value={}></input>
        <label>PW : </label>
        <input></input>
        <label>EMAIL : </label>
        <input></input>
        <label>NAME : </label>
        <input></input>
    </div>
        </>
    );
};
export default SignUp;