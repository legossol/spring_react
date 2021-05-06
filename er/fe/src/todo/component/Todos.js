import React from 'react'
import { Todo } from 'todo/index'
import {useDispatch} from 'react-redux'

const Todos = ({todos, delTodo, delAll,delTodoFilter, toggleTodo}) => {
    const dispatch = useDispatch()
    const onClick = () =>{
        alert(`${JSON.stringify(todos)}`)
        dispatch(delAll())
    }
    return (<>
    <h3>할일 목록 <button style={{width:70}} onClick={onClick}>전체삭제</button></h3>
    <div>
        {todos.map(todo => (<Todo key={todo.id} todo={todo} delTodo={delTodo} 
        delAll={delAll} delTodoFilter={delTodoFilter} toggleTodo={toggleTodo}/>))}
    </div>
    </>)
}
export default Todos