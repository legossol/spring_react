//import '../component/signupForm.css';
import React, { useCallback, useState } from 'react';
import axios from 'axios';

const SignUp = () => {
    const [inputs, setInputs] = useState({
        username: '',
        password: '',
        userEmail: '',
        userAddress: '',
        userPhoneNumber: '',
    });

    const { username, password, userEmail, userAddress, userPhoneNumber } = inputs;

    const handleChange = useCallback(
        (e) => {
            const { value, name } = e.target;
            setInputs({
                ...inputs,
                [name]: value,
            });
        },
        [inputs]
    );

    const handleSubmit = useCallback(
        (e) => {
            alert('회원가입 버튼누름');

            e.preventDefault();
            console.log('작동');

            alert('ID : ' + username);
            alert('비밀번호 : ' + password);
            alert('email : ' + userEmail);
            alert('주소 : ' + userAddress);
            alert('핸드폰 번호 : ' + userPhoneNumber);

            axios
                .post('http://localhost:8080/users/insert', {
                    username,
                    password,
                    userEmail,
                    userAddress,
                    userPhoneNumber,
                })
                .then((res) => {
                    console.log(res);
                })
                .catch((err) => console.log(err));
        },
        [username, password, userEmail, userAddress, userPhoneNumber]
    );

    return (
        <form onSubmit={handleSubmit} method="post">
            <div className="signUpContainer">
                <h1>회원가입</h1>

                <hr />

                <label htmlFor="username">
                    <b>아이디</b>
                </label>
                <input type="text" onChange={handleChange} placeholder="Username" name="username" value={username} required />

                <label htmlFor="password">
                    <b>비밀번호</b>
                </label>
                <input type="password" onChange={handleChange} placeholder="Password" name="password" value={password} required />

                <label htmlFor="userEmail">
                    <b>Email</b>
                </label>
                <input type="text" onChange={handleChange} placeholder="UserEmail" name="userEmail" value={userEmail} required />

                <label htmlFor="userAddress">
                    <b>주소</b>
                </label>
                <input type="text" onChange={handleChange} placeholder="UserAddress" name="userAddress" value={userAddress} required />

                <label htmlFor="userPhoneNumber">
                    <b>핸드폰 번호</b>
                </label>
                <input type="text" onChange={handleChange} placeholder="UserPhoneNumber" name="userPhoneNumber" value={userPhoneNumber} required />

                <div className="clearfix">
                    <button type="button" className="cancelButton">
                        Cancel
                    </button>
                    <button type="submit" className="signupButton">
                        회원가입 버튼
                    </button>
                </div>
            </div>
        </form>
    );
};
export default SignUp;
