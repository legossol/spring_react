import React, { useState, useEffect,useCallback } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import 'user/style/UserList.css'
import {getUserList} from '../reducer/user.reducer'


const UserList = () => {
    const users = useSelector(state => {
        console.log("state: " + JSON.stringify(state))
        return state.users
    });
    const dispatch = useDispatch();
    useEffect(() =>{
        alert(`1. useEffect`)
        dispatch(getUserList());
    },[]);


    const userList = useSelector((state) => state.userReducer);

    

    return (<>
    <div className="container">
            <h1>사용자 리스트</h1>
            <hr/>
            <table style={{border: "10"}}>
            <thead>
                <tr>
                    <th>username</th>
                    <th>name</th>
                    <th>email</th>
                </tr>
            </thead>
            <tbody>
            {users.map((user, id) => {
                return (
                    <tr key={id}>
                            <td>{user.username}</td>
                            <td>{user.name}</td>
                            <td>{user.email}</td>
                    </tr>)
            })}
            </tbody>
        </table>
        </div>
  </>)
};
export default UserList;