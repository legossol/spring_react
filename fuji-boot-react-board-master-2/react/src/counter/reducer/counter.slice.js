import { createSlice } from '@reduxjs/toolkit'

const counterSlice = createSlice({
    name: 'counterSlice',
    initialState: {number: 0},
    reducers: {
        increase(state, action){//앞에 function이 생략된 형태
            console.log('increase :: '+JSON.stringify(state.number))
            return {number: state.number + action.payload}},
        decrease(state, action){
            console.log('decrease :: '+JSON.stringify(state.number))
            return {number: state.number - action.payload}},
    }
   
})
const { actions, reducer } = counterSlice
export const { increase, decrease } = actions
export default reducer