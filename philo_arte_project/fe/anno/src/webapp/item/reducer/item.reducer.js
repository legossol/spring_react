import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import {ItemService} from '../index'


export const getItemList = createAsyncThunk(
    "item/list",
    async() =>{
        const response = await ItemService.findALl()
        return response.data
    }
)
export const itemRegister = createAsyncThunk(
    "item/register",
    async (item) =>{
        const response = await ItemService.itemRegister(item)
        return response.data
    }
)

const isRejectAction=action=>
     (action.type.endsWith('rejected'))

const itemSlice = createSlice({
    name: "items",
    initialState: [],
    reducers:{},
    extraReducers: (builder)=>{
        builder
        .addCase(getItemList.fulfilled,(state, {payload})=>{
            return [...payload]
        })
        .addMatcher(isRejectAction,() =>{})
        .addDefaultCase((state, payload)=>{})
    },
})
const {reducer} = itemSlice
export default reducer 