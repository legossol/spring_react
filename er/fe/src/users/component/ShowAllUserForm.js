import React, { useState, useEffect,useCallback } from "react";
import { Link } from "react-router-dom";
import ReadUser from "./ReadUser";

const ShowAllUserForm = (props) => {
  console.log("ShowAllUserForm props:",JSON.stringify(props) )
  console.log("ShowAllUserForm locatiousernobject:",JSON.stringify(props) )
  


    return (<>
    <table>
                <thead>
                    <tr>
                        <th>userno</th>
                        <th>이름</th>
                        <th>아이디</th>
                        <th>비밀번호</th>
                        <th>이메일</th>
                        <th>나이</th>
                        <th>생일</th>
                        <th>성별</th>
                        <th>등록날짜</th>
                        <th>핸드폰번호</th>
                    </tr>
                </thead>
                <tbody>
                {props.users.length > 0 ? (
                        props.users.map(user => {
                            const {userno, name, username, password, email, age, birthday, gender,date, phone} = user;
                            return(
                            <tr key={userno}>
                                <td>{userno}</td>
                            <td>{name}</td>
                            <td>{username}</td>
                            <td>{password}</td>
                            <td>{email}</td>
                            <td>{age}</td>
                            <td>{birthday}</td>
                            <td>{gender}</td>
                            <td>{date}</td>
                            <td>{phone}</td>
                            <td>
                              <Link to={`/ReadUser/${userno}`} className="linkto-ShowAllUser">
                              <button onClick={() => {
                                        localStorage.setItem('userno',`${userno}`)
                                    }}>자세히보기</button>
                              </Link>
                            </td>
                        </tr>
        )
      })
      ) : (
          <tr>
              <td colSpan={9}>userno User Found</td>
          </tr>
          )
      }
                </tbody>
                <tr>
                    <td>
                    <Link to={`/JoinUser`} >
                    <button className="button-primary">등록하기</button></Link>
                    </td>
                </tr>
            </table>
  </>)
};
export default ShowAllUserForm