import React from 'react';
import 'user/style/SignUp.css';
const SignUp = () => {
    return (
        <>
        <div className="container">
        <h1>사용자 등록</h1>
        <hr/>
        <label>ID : </label>
        <input></input>
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