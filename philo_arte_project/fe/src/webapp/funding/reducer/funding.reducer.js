import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import {FundingService} from '../index'

export const getFundingList = createAsyncThunk(
    "fundings/list",
    async(page) =>{
        const response = await FundingService.getList(page)
        return response.data
    }
)
export const saveFunding = createAsyncThunk(
    "funding/register",
    async (newFunding) =>{
        const response = await FundingService.fundingRegister(newFunding)
        console.log("saveFunding action  ===" +newFunding)
        
        return response.data
    }
)
export const getFundingDetail = createAsyncThunk(
    "funding/Detail",
    async(fundingId)=>{
        const response = await FundingService.showDetail(fundingId)
        console.log("export const 의 fundingNo :"+ fundingId)
        console.log("export const 의 response"+ response)   
        return response.data 
        // return {...state, selected: state.boards.find(post => post.id === action.postId)}
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
    async(fundingId)=>{
        const ressponse = await FundingService.deleteFunding(fundingId)
        return ressponse.data
    }
)

const isRejectAction=action=>
     (action.type.endsWith('rejected'))

const fundingSlice = createSlice({
    name: "fundings",
    initialState: {
        param:{},
        pageResult:{
            dtoList:[],
            page:1,
            pageList:[],
            start:1,
            end:1,
            prev:false,
            next:false
        },
        fileList:[]
        
    },
    reducers:{
        addFileList:(state,{payload})=>{
            state.fileList.push(payload)
        }
    },
    extraReducers: (builder)=>{
        builder
        .addCase(getFundingList.fulfilled,(state, {payload})=>{
            state.pageResult = payload
        })
        .addCase(getFundingDetail.fulfilled,(state,{payload})=>{
            console.log("extra ==============="+ JSON.stringify(payload))
            state.current = payload
        })
        .addCase(updateFunding.fulfilled,(state,{payload})=>{
            return state.find(funding => funding.id == payload)
            //
        })
        .addCase(saveFunding.fulfilled,(state,{payload})=>{
            state.fundings = payload
            // return [state, {...payload}]
            // return state.push(newFunding => state.newFunding = payload)
        })
        .addCase(deleteFunding.fulfilled,(state,{payload})=>{
            alert(`delete : ${payload}`)
            return state.filter((funding) => funding.fundingId == payload)
            
        })
        .addMatcher(isRejectAction,() =>{})
        .addDefaultCase((state, payload)=>{})
    },
})



const {actions ,reducer} = fundingSlice
export const currentFunding = state => state.fundings.current
export const dtoPath = state => state.fundings.pageResult.dtoList

export const {addFileList}=actions
export default reducer 

// const funding = state.find(funding => funding.fundingNo == payload)
//             return funding ? payload : funding.fundingNo;