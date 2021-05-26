import React from 'react';
import {Route} from "react-router-dom"
import './App.css';
import {Todo, Todos,TodoList} from "todo/index"
const App=()=> {
  return (
  
      <div>
      <Route exact path="/todo" component={Todos}/>
      <Route exact path="/todolist" component={TodoList}/>

      </div>
  );
}

export default App;
