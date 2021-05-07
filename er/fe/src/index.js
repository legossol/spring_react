import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from 'reportWebVitals';
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux'
import {createStore, combineReducers, applyMiddleware} from 'redux'
import store from "store/index"
import thunk from 'redux-thunk';



const rootReducer = combineReducers({counterSlice, todoReducer, userReducer})
// const store = createStore(rootReducer) 바닐라 리덕스
const store = configureStore({reducer:rootReducer}, applyMiddleware(thunk))

ReactDOM.render(
  <Provider store={store}>
    <BrowserRouter>
    <App/>
  </BrowserRouter>
  </Provider>,
 
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();