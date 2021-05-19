import { combineReducers, configureStore, getDefaultMiddleware } from "@reduxjs/toolkit";
import logger from "redux-logger"
import resumes from "webapp/resume/reducer/resume.reduce"
import fundings from "webapp/funding/reducer/funding.reducer"

const rootReducer = combineReducers({resumes,fundings});

export default configureStore({
    reducer: rootReducer,
    middleware: [...getDefaultMiddleware(), logger],
});