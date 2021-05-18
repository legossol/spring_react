import './App.css';
import {Route} from 'react-router-dom'
import {FundingList,FundingDetail,FundingRegister,FundingUpdate} from "webapp/funding/index";
import {FileHome, FileRegister} from "webapp/common/file/"
function App() {
  return (
   <div className="App">
        
          <Route exact path="/funding/list" component={FundingList}/>
          <Route exact path="/funding/detail" component={FundingDetail}/>
          <Route exact path="/funding/update" component={FundingUpdate}/>
          <Route exact path="/funding/register" component={FundingRegister}/>

          <Route exact path="/uploadAjax" component={FileRegister}/>
          <Route exact path="/display" component={FileHome}/>
          </div>
    
  );
}

export default App;
