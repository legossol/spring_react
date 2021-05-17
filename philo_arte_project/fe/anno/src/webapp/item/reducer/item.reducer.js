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
        console.log(newItem)
        
        return response.data
    }
)
export const getItemDetail = createAsyncThunk(
    "item/Detail",
    async(itemNo)=>{
        const response = await ItemService.showDetail(itemNo)
        console.log("export const 의 itemNo"+ itemNo)
        console.log("export const 의 response"+ response)
        return response.data 
    }
)
export const updateItem = createAsyncThunk(
    'item/update',
    async(itemNo)=>{
        const response = await ItemService.updateByItemID(itemNo)
        return response.data

    }
)
export const deleteItem = createAsyncThunk(
    "item/deleteById",
    async(id)=>{
        const ressponse = await ItemService.deleteItem(id)
        return ressponse.data
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
        .addCase(getItemDetail.fulfilled,(state,{payload})=>{
            console.log("디테일에드 케이스" + state +"payloda :"+[...payload])
            return [...payload]
            // state.map((item) => item.id !== payload.id)
        })
        .addCase(updateItem.fulfilled,(state,{payload})=>{
            return state.map((post)=>post.id === payload.id ? {...post,editing:!post.editing}:post)
        })
        .addCase(saveItem.fulfilled,(state,{payload})=>{
            return state.push(...payload)
        })
        .addCase(deleteItem.fulfilled,(state,{payload})=>{
            alert(`delete : ${payload}`)
            return state.filter((item) => item.id !== payload.id)
        })
        .addMatcher(isRejectAction,() =>{})
        .addDefaultCase((state, payload)=>{})
    },
})
const {reducer} = itemSlice
export default reducer 

// const item = state.find(item => item.itemNo == payload)
//             return item ? payload : item.itemNo;