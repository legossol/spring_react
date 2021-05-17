import logo from './logo.svg';
import './App.css';
import {Route} from 'react-router-dom'
import {FundingList,FundingDetail,FundingRegister,FundingUpdate} from "webapp/funding/index";
          
function App() {
  return (
   <div className="App">
        
          <Route exact path="/funding/list" component={FundingList}/>
          <Route exact path="/funding/detail" component={FundingDetail}/>
          <Route exact path="/funding/update" component={FundingUpdate}/>
          <Route exact path="/funding/register" component={FundingRegister}/>
    
          </div>
    
  );
}

export default App;
