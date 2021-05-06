import React, { useState, useEffect,useCallback } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const UserDetail = () => {
 
        return (<><div className="container">
        <h1>사용자 정보</h1>
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
        </>);
};
export default UserDetail;