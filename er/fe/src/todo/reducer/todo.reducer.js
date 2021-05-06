import { DoneAllOutlined } from '@material-ui/icons'
import { createSlice } from '@reduxjs/toolkit'
import uuid from 'uuid/v4'
const initialState = [
    {id: 1, text: '리액트 학습', done: true},
    {id: 2, text: '리덕스', done: true},
    {id: 3, text: '썽크', done: false},
]
// 기능: addTodo, findTodo, editTodo, remove
const todoReducer = createSlice({
    name: 'todoReducer',
    initialState,
    reducers: {
        addTodo(state, {payload}){ state.push({id: uuid(), text: payload, done: false})},

        delTodo(state, {payload}){ 
            alert(`id : ${payload} 를 +삭제합ㄴ니다.`)
            state.splice(payload,1)
        },
    
        delAll(state, {payload}){state.splice(payload)},

        delTodoFilter(state,{payload}){
            alert(`${payload}`)
            // state.splice(state.findIndex(()=>{(j=>j.id===payload)},1))
            return state.filter((todo) => todo.id !== payload)
        },
        toggleTodo(state,{payload}){
            const toggle = state.find((todo) =>todo.id ===payload)
            alert('===>' + JSON.stringify(toggle))
                toggle.done = !toggle.done;
        }

    }})
const { actions, reducer } = todoReducer
export const {addTodo,delTodo,delAll,delTodoFilter,toggleTodo} = actions
export default reducer