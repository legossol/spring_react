import{ createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import {ResumeService} from "webapp/resume/index";


export const listResume = createAsyncThunk(
    "resume/list",
    async () =>{
        const response = await ResumeService.resumeList();
        return response.data;
    }
)
export const registerResume = createAsyncThunk(
    "resume/register",
    async(resume) =>{
        const response = await ResumeService.resumeRegister(resume)
        return response.data;
    }
)

export const readResume = createAsyncThunk(
    "resume/read",
    async(resumeId) =>{
        const response = await ResumeService.resumeRead(resumeId);
        return response.data;
    }
)

export const modifyResume = createAsyncThunk(
    "resume/modify",
    async (resume) =>{
        const response = await ResumeService.resumeModify(resume);
        return response.data;
    }
)

export const deleteResume = createAsyncThunk(
    "resume/delete",
    async (resumeId) => {
        const response = await ResumeService.resumeDelete(resumeId)
        return response.data;
    }
)

const isRejectedAction = action => (action.type.endsWith('rejected'))

const resumeSlice = createSlice({
    name: 'resumes',
    initialState: [],
    reducers: {

    },
    extraReducers: (builder) => {
        builder
        .addCase(listResume.fulfilled, (state,{payload}) => {
            return [...payload];
        })
        .addCase(registerResume.fulfilled,(state,{payload}) => {
            return state.push(...payload)
        })
        .addCase(readResume.fulfilled,(state,{payload}) => {
            const resume = state.find(resume => resume.resumeId == payload)
            return resume ? payload : "선택하신 포트폴리오는 없는 포트폴리오입니다." + resume.resumeId;
        })
        .addCase(modifyResume.fulfilled,(state,{payload}) => {
            const resume = state.findIndex(resume => resume.resumeId == payload)
            return resume ? {...payload} : "선택하신 포트폴리오는 없는 포트폴리오입니다." + resume.resumeId;
        })
        .addCase(deleteResume.fulfilled,(state,{payload}) => {
            return state.filter(resume => resume.resumeId == payload)
        })
        .addMatcher(isRejectedAction).addDefaultCase();
    }
})

const {actions, reducer} = resumeSlice;
export const {} = actions;
export default reducer;