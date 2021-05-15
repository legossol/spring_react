import {combineReducers, configureStore, getDefaultMiddleware} from '@reduxjs/toolkit'
import logger from "redux-logger"
import items from '../item/reducer/item.reducer'
 const rootReducer = combineReducers({items})

 export default configureStore({
     reducer: rootReducer,
     middleware: [...getDefaultMiddleware(), logger]
 })