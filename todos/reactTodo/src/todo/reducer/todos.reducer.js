import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

import {TodoService} from 'todo/index'
// const initialState = [
//   {tno: '1', title: '사이클링', content: '상구와 한강 싸이클', regDate:'2014-02-13', modDate:'2014-02-14'}
// ]
export const getdata = createAsyncThunk(
  "todo/data",
  async()=>{
    const response  = await TodoService.readData()
    return response.data
  }
)
const isRejectAction=action=>
     (action.type.endsWith('rejected'))

const todoSlice = createSlice({
  name: "todos",
  initialState:{
    todoList: [],
    msg:''
  },
  reducers:{},
  extraReducers: builder=>{
    builder
    .addCase(getdata.fulfilled,(state, {payload})=>{
      state.todoList = payload.todoList
    })
    .addMatcher(isRejectAction,()=>{})
    .addDefaultCase((state, payload) =>{})
}
})
const {reducer} = todoSlice
export default reducer