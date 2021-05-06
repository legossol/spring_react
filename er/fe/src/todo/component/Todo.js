import React from 'react'
import {useDispatch} from 'react-redux'
const Todo = ({todo,delTodo,delTodoFilter,toggleTodo}) => {
    const dispatch = useDispatch()
    const deleteOnClick = () =>{
        dispatch(delTodo(todo.id-1))
    }
    const delsfilter = () =>{
        dispatch(delTodoFilter(todo.id))
    }
    const toggleClick = () =>{
        
        alert('checkbos checkedd ID :'+todo.id)
        
        dispatch(toggleTodo(todo.id))
    }
    return (<div style={{width:600}}>
        <input type="checkbox" style={{width:100}} onClick={toggleClick}/>
        {(todo.done)?
        <del><span style={{width:400,color:'black'}} > {todo.text} </span></del>
        :<span style={{width:400,color:'black'}} > {todo.text} </span>}

        <button style={{width:100, backgroundColor:'red'}}onClick={deleteOnClick}>splice삭제</button>
        <button style={{width:100, backgroundColor:'red'}}onClick={delsfilter}>filter삭제</button>

    </div>)
}
export default Todo