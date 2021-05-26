import React, {Component} from 'react'

const AddTodo = () =>{
  constructor = props => {
    super(props);
    this.onClick = this.onClick.bind(this);
  }

  componentDidMount=()=> {
    this.inputTodo = document.querySelector('#inputTodo');
  }

  onClick=(e)=> {
    e.preventDefault();
    const { addTodo } = this.props;
    addTodo(this.inputTodo.value);
    this.inputTodo.value = ''; 
  }

  
    return (
      <form id='addTodo'>
        <input id='inputTodo' placeholder='Enter todo'/>
        <button type='submit' onClick={this.onClick}>ADD</button>
      </form>
    );
  
}

export default AddTodo;