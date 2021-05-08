import axios from 'axios'
import {UserService} from 'user/index'
import {createAsyncThunk, createSlice, isFulfilled} from '@reduxjs/toolkit'


export const getUserList = createAsyncThunk(
    
    "users/findAll",
    async() =>{
    const response = await UserService.findAll()
    return response.data
})
export const registerUser = createAsyncThunk(
    "users/signup",
    async() =>{
        const response = await UserService.signup()
        return response.data
    }
)

const isRejectedAction = action => 
(action.type.endsWith('rejected'))//round brace걸면 return자동으로 됨

const userSlice = createSlice({
    name: 'users',
    initialState:[],
    reducers:{},
    extraReducers:(builder) => {
        builder
        .addCase(getUserList.fulfilled, (state, {payload}) =>{
            alert(`3 리덕스 내부 회원 목록 조회 성공${payload}`)
            return[...payload]
        })
        .addMatcher(isRejectedAction, () =>{})
        .addDefaultCase((state, action) =>{})
    }
})

const {actions, reducer} = userSlice
export const {} = actions
export default reducer