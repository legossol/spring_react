import React, { useState, useEffect,useCallback } from "react";
import { Link } from "react-router-dom";
import 'user/style/UserList.css'
const UserList = () => {

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