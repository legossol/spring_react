
import React, { useState, useEffect,useCallback } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import ShowAllUserForm from "./ShowAllUserForm";
import ReadUser from "./ReadUser"
import JoinUserForm from "./JoinUserForm"
import EditUserForm from "./EditUserForm"



const ShowAllUser = (props) => {
    console.log("ShowAllUser props:",JSON.stringify(props) )
   
    const [users, setUsers] = useState([]);

    const addUser = useCallback(user => {
        user.userno = users.length +1;
        setUsers([...users,user]);
      },[users]); 

const deleteUser = useCallback( userno => 
  setUsers(users.filter( user =>user.userno !== userno)),
  [users]);





      

    const fetchList = () => {
        axios.get(`http://localhost:8080/users/list`)
            .then((res) => {
                console.log("리스트를 불러왔습니다",res);
                setUsers(...users, res.data);
            })
            .catch((err) => console.log(err));
    };
    useEffect(() => {
        fetchList();
    }, []);

   return(<>
        <div className="container">
      <div className="row">
          <h2>AllUser of List</h2>
          <ShowAllUserForm
          users={users}
          ></ShowAllUserForm>
        </div>
        </div>
    </>)
}
export default ShowAllUser;