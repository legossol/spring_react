import React from 'react'
import '../component/SignUp.css';
import axios from 'axios'

const SignUp = () => {
    const insertMany = () => {
      alert(`더미데이터 입력`)
      axios.get(`/auth/insertMany`)
      .then(res => {
        alert(`${res.data.message} 명 등록됨 ` )
      })
      .catch(err => {
        alert(`FAILURE`)
      })
    }
    return  (
      <form style={{border:"1px solid #ccc"}}>
        <div className="container">
          <h1>Sign Up</h1>
          <p>Please fill in this form to create an account.</p>
          <hr/>
  
          <label htmlFor="email"><b>Email</b></label>
          <input type="text" placeholder="Enter Email" name="email" />
  
          <label htmlFor="psw"><b>Password</b></label>
          <input type="password" placeholder="Enter Password" name="psw" />
  
          <label htmlFor="psw-repeat"><b>Repeat Password</b></label>
          <input type="password" placeholder="Repeat Password" name="psw-repeat" />
          
          <label>
            <input type="checkbox" defaultChecked="defaultChecked" name="remember" style={{marginBottom:"15px"}}/> Remember me
          </label>
          
          <p>By creating an account you agree to our.</p>
  
          <div className="clearfix">
            <button type="button" className="cancelbtn">Cancel</button>
            <button type="submit" className="signupbtn" onClick={insertMany}>Sign Up</button>
          </div>
        </div>
      </form>
  
    )
}


  
  


export default SignUp;