import {combineReducers, configureStore, getDefaultMiddleware} from '@reduxjs/toolkit'
import logger from "redux-logger"
import fundings from '../funding/reducer/funding.reducer'

const rootReducer = combineReducers({fundings})

 export default configureStore({
     reducer: rootReducer,
     middleware: [...getDefaultMiddleware(), logger]
 })