import React, { useState,useCallback} from 'react';
import axios from 'axios';

const JoinUserForm = (props) => {
    console.log("JoinUserForm props:",JSON.stringify(props) )

   
    
    const initUser = { name: '', username: '', password: '', email: '',age: '',birthday: '', gender: '', phone:'',}

    const [user, setUser] = useState(initUser);

    const {name, username, password, email, age, birthday, gender, phone} = user

   

    const handleChange = useCallback( e => {
        const {name, value} = e.target;
        setUser({...user,
             [name]: value});
            },[user]) 

const handleSubmit =useCallback( e => {
    e.preventDefault();
    if(user.name && user.username && user.password && user.email && user.age && user.birthday && user.gender && user.phone) { 
        axios.post('http://localhost:8080/users/join',{name, username, password, email, age, birthday, gender, phone})
        .then( res => {
            alert("등록이 되었음", res)
        window.location = '/ShowAllUser'
        })
        .catch(err => console.log(err))}
        else{
            alert(" 모든 항목 작성하시오")
        }
    },[name, username, password, email, age, birthday, gender, phone])

    return (<>
    <form onSubmit={handleSubmit} method={"post"}>
            <label>name</label>
            <input className="u-full-width" type="text" name="name" value={name} onChange={handleChange}/>
            <label>userID</label>
            <input className="u-full-width" type="text" name="username" value={username} onChange={handleChange} />
            <label>passwod</label>
            <input className="u-full-width" type="text" name="password" value={password} onChange={handleChange} />
            <label>email</label>
            <input className="u-full-width" type="text" name="email" value={email} onChange={handleChange}/>
            <label>age</label>
            <input className="u-full-width" type="text" name="age" value={age} onChange={handleChange}/>
            <label>birthday</label>
            <input className="u-full-width" type="text" name="birthday" value={birthday} onChange={handleChange}/>
            <label>gender</label>
            <input className="u-full-width" type="text" name="gender" value={gender} onChange={handleChange}/>
            <label>phone</label>
            <input className="u-full-width" type="text" name="phone" value={phone} onChange={handleChange}/>

            <button className="button-primary" type="submit" onClick={()=>handleSubmit}>Add User</button>
        </form>
      </>);
}
export default JoinUserForm;