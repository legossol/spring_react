import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import {FundingService} from '../index'


export const getFundingList = createAsyncThunk(
    "funding/list",
    async() =>{
        const response = await FundingService.findAll()
        return response.data
    }
)
export const saveFunding = createAsyncThunk(
    "funding/register",
    async (newFunding) =>{
        const response = await FundingService.fundingRegister(newFunding)
        console.log(newFunding)
        
        return response.data
    }
)
export const getFundingDetail = createAsyncThunk(
    "funding/Detail",
    async(fundingNo)=>{
        const response = await FundingService.showDetail(fundingNo)
        console.log("export const 의 fundingNo :"+ fundingNo)
        console.log("export const 의 response"+ response)
        return response.data 
    }
)
export const updateFunding = createAsyncThunk(
    'funding/update',
    async(fundingNo)=>{
        const response = await FundingService.updateByFundingID(fundingNo)
        return response.data

    }
)
export const deleteFunding = createAsyncThunk(
    "funding/deleteById",
    async(id)=>{
        const ressponse = await FundingService.deleteFunding(id)
        return ressponse.data
    }
)
const isRejectAction=action=>
     (action.type.endsWith('rejected'))

const fundingSlice = createSlice({
    name: "fundings",
    initialState: [],
    reducers:{},
    extraReducers: (builder)=>{
        builder
        .addCase(getFundingList.fulfilled,(state, {payload})=>{
            return [...payload]
        })
        .addCase(getFundingDetail.fulfilled,(state,{payload})=>{
            console.log("디테일에드 케이스" + state +"payloda :"+[...payload])
            return state.find(funding => funding.id === payload.id)
            
        })
        .addCase(updateFunding.fulfilled,(state,{payload})=>{
            return state.find(funding => funding.id == payload)
            // map((post)=>post.id === payload.id ? {...post,editing:!post.editing}:post)
            
        })
        .addCase(saveFunding.fulfilled,(state,{payload})=>{
            return state.push(...payload)
        })
        .addCase(deleteFunding.fulfilled,(state,{payload})=>{
            alert(`delete : ${payload}`)
            return state.filter((funding) => funding.id !== payload.id)
        })
        .addMatcher(isRejectAction,() =>{})
        .addDefaultCase((state, payload)=>{})
    },
})
const {reducer} = fundingSlice
export default reducer 

// const funding = state.find(funding => funding.fundingNo == payload)
//             return funding ? payload : funding.fundingNo;