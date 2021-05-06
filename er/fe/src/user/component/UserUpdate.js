import React, { useState, useEffect, useCallback } from "react";
import axios from 'axios';
import { Link } from "react-router-dom";

const UserUpdate = () => {
    return (<> 
        <div className="container">
            <h1>사용자 수정</h1>
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
    </>);
}
export default UserUpdate;