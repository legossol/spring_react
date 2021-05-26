import React, { useEffect } from 'react'
import {useDispatch, useSelector} from 'react-redux'
import {getdata} from 'todo/reducer/todos.reducer'

const Todo = () =>{
    const todos = useSelector(state =>{
        console.log("state : " + JSON.stringify(state.todos))
        return state.todos.todoList
    })
    const dispatch = useDispatch()

    useEffect (()=>{
        dispatch(getdata())
    },[])
    
    const renderData = (todos) => {
              return (
                <ul>
                  {todos.map((todo, tno) => {
                    return <li key={tno}>{todo.title}</li>;
                  })}
                </ul>
              );
    };
    return(
        <>
        <div>
        <h2> Todo Page</h2>
        {renderData(todos)}
        </div>
        </>
    )
}
export default Todo