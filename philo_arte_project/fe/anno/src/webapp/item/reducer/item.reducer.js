import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import {ItemService} from '../index'


export const getItemList = createAsyncThunk(
    "item/list",
    async() =>{
        const response = await ItemService.findAll()
        return response.data
    }
)
export const saveItem = createAsyncThunk(
    "item/register",
    async (newItem) =>{
        const response = await ItemService.itemRegister(newItem)
        alert("등록이 될까? 리듀서" + newItem)
        console.log(newItem)
        
        return response.data
    }
)
export 
export const deleteItem = createAsyncThunk(
    `item`,
    async () =>{
        const response = await ItemService.deleteItem()
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
        .addCase(saveItem.fulfilled,(state,{payload})=>{
            return [...payload]
        })
        .addCase(deleteItem.apply,(state,{payload})=>{
            return [...payload]
        })
        .addMatcher(isRejectAction,() =>{})
        .addDefaultCase((state, payload)=>{})
    },
})
const {reducer} = itemSlice
export default reducer 