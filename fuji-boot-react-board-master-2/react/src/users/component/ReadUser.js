import React, { useState, useEffect,useCallback } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const ReadUser = ({match}) => {
    console.log("ReadUser props:",JSON.stringify(match.params) )


    const [user, setUser] = useState({})
    const fetchRead = () =>{
        axios.get(`http://localhost:8080/users/${localStorage.getItem('userno')}`)
        .then(res =>{
            console.log("자세한리스트를 가져옵니다",res);
            setUser(res.data);

        })
        .catch(err => {
            console.log("에러러러러러ㅓ",err)
        })
    };
    useEffect(() => {
        fetchRead()
    }, []);
    const initUser = { name: '', username: '', password: '', email: '',age: '',birthday: '', gender: '', phone:'',}
    // const [editing, setEditing] = useState(false);
    const [currentUser, setCurrentUser] = useState(initUser);

    const deleteUser = useCallback( () =>{
        axios.delete(`http://localhost:8080/users/${localStorage.getItem('userno')}`)
        .then(res =>{
            alert ('유저가 삭제되었습니다.')
            window.location = '/ShowAllUser'
        })
        .catch(err => {
            console.log(err)
        })
    }
    )

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
                            <tr key={user.userno}>
                                <td>{user.name}</td>
                                <td>{user.username}</td>
                                <td>{user.password}</td>
                                <td>{user.email}</td>
                                <td>{user.age}</td>
                                <td>{user.birthday}</td>
                                <td>{user.gender}</td>
                                <td>{user.regDate}</td>
                                <td>{user.phone}</td>
                                <td>
                                <button onClick={() => deleteUser()}>Delete</button>
                                <Link to={`/EditUser/${user.userno}`}> <button>Edit</button> </Link>
                               
                                </td>
                            </tr>
                </tbody>
            </table>
        </>);
};
export default ReadUser;