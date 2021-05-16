import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import {ItemService} from '../index'
import itemService from '../service/item.service'


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
export const getItemDetail = createAsyncThunk(
    "item/list",
    async(itemNo)=>{
        const response = await ItemService.showDetail(itemNo)
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
        const ressponse = await itemService.deleteItem(id)
        return ressponse.data
    }
)
// export const deleteItem = createAsyncThunk('item/deleteById', async (itemNo) =>{
//         const response = await ItemService.deleteItem(`http://localhost:8000/item/${itemNo}`)
//         return itemNo
//     }
// )
// export const deleteList = createAsyncThunk("DELETE_TODO", async (listId) => {
//     const response = await axios.delete(`http://localhost:8000/list/${listId}`);
//     return listId;
//   });
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
            return state =payload
        })
        // .addCase(showItemDetail.fulfilled,(state,{payload})=>{
        //     return[...payload]
        // })
        .addCase(updateItem.fulfilled,(state,{payload})=>{
            return state.map((post)=>post.id === payload.id ? {...post,editing:!post.editing}:post)
        })
        .addCase(saveItem.fulfilled,(state,{payload})=>{
            return [...state,...payload]
        })
        .addCase(deleteItem.fulfilled,(state,{payload})=>{
            alert(`delete : ${payload}`)
            return state.filter((item) => item.id !== payload.id)
        })
        // .addCase(updateItem.fulfilled,(state,{payload})=>{
        //     return [...payload]
        // })
        .addMatcher(isRejectAction,() =>{})
        .addDefaultCase((state, payload)=>{})
    },
})
const {reducer} = itemSlice
export default reducer 