import React, { useState, useEffect,useCallback } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import 'user/style/UserList.css'
import getUserList from '../reducer/user.reducer'


const UserList = () => {
    const dispatch = useDispatch();
    useEffect(() =>{
        dispatch(getUserList());
    },[]);


    const userList = useSelector((state) => state.userReducer);

    

    return (<>
    <div className="container">
            <h1>사용자 리스트</h1>
            <hr/>
            <table>
            <thead>
                    <tr>
                        <th>유저 고유ID</th>
                        <th>유저 설정ID</th>
                        <th>비밀번호</th>
                        <th>이메일</th>
                        <th>유저 이름</th>
                    </tr>
                </thead>
            </table>
        </div>
  </>)
};
export default UserList;