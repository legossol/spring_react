import './App.css';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom'
import ScrollIntoView from "./webapp/common/helpers/ScrollIntoView"
import ScrollToTop from "./webapp/common/helpers/ScrollToTop"
import {HomeVideoBg} from "webapp/common/index"

import {FundingList,FundingDetail,FundingRegister,FundingUpdate} from "webapp/funding/index";
import {FileHome, FileRegister, PerformanceInput,UploadInput,BoardRegister,BoardPage} from "webapp/common/file/"
function App() {
  return (
    <Router basename="/">
    <ScrollIntoView>
      <ScrollToTop>
        <Switch>
          <Route
            exact
            path={`/`}
            component={HomeVideoBg}
          />
          {/*Funding*/}
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
          </Switch>
        </ScrollToTop>
      </ScrollIntoView>
    </Router>
    
  );
}

export default App;
