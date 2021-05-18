import './App.css';
import {Route} from 'react-router-dom'
import {FundingList,FundingDetail,FundingRegister,FundingUpdate} from "webapp/funding/index";
import {FileHome, FileRegister, PerformanceInput,UploadInput,BoardRegister,BoardPage} from "webapp/common/file/"
function App() {
  return (
   <div className="App">
        
          <Route exact path="/funding/list" component={FundingList}/>
          <Route exact path="/funding/detail" component={FundingDetail}/>
          <Route exact path="/funding/update" component={FundingUpdate}/>
          <Route exact path="/funding/register" component={FundingRegister}/>

          {/* <Route exact path="/uploadAjax" component={FileRegister}/>
          <Route exact path="/display" component={FileHome}/> */}
          <Route exact path="/display" component={PerformanceInput}/>
          <Route exact path="/uploadAjax" component={UploadInput}/>
          <Route exact path="/filelist" component={BoardRegister}/>
          <Route exact path="/board" component={BoardPage}/>
          
          </div>
    
  );
}

export default App;
