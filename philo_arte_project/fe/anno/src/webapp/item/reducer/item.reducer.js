import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'



const initialState = [
    {id: 1, title: '로봇 묵화그리기', writer:'ssol',content:'나나나너너너너너',goalPrice:300000, viewCnt:3},
    {id: 2, title: '광화문에 똥싸기', writer:'아무개',content:'나나나너너너너너',goalPrice:25000, viewCnt:1}
]

const itemReducer = createSlice({
    name: 'itemReducer',
    initialState,
    reducers:{
        deleteItem(state, {payload}){
            alert(`id : ${payload} 를 삭제합니다.`)
            state.splice(payload,1)
        }
    }
})

const{action, reducer} = itemReducer

export const {deleteItem} = action
export default reducer 