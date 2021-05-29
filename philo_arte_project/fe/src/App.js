import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import ScrollIntoView from "./webapp/common/helpers/ScrollIntoView";
import ScrollToTop from "./webapp/common/helpers/ScrollToTop";

import {ResumeApp, ResumeList, ResumeModify, ResumeRead, ResumeRegister} from 'webapp/resume/index'
import {FundingHome, FundingList, FundingUpdate,FundingRegister, FundingDetail} from 'webapp/funding/index'
import {ItemList, ItemModify, ItemRead, ItemRegister} from 'webapp/item/index'
import {ReviewList, ReviewModify, ReviewRead, ReviewRegister} from 'webapp/review/index'
import {WorkList, WorkModify, WorkRead, WorkRegister} from 'webapp/work/index'
import {UploadInput, PerformanceInput, BoardPage, BoardRegister} from 'webapp/common/file/index'
import { HomeVideoBg } from "webapp/common/index";

const App=()=> {
  
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
              {/*Resume*/}
            <Route exact path="/resume/home" component={ResumeApp}/>
            <Route exact path='/resume/list' component={ResumeList}/>
            <Route exact path='/resume/modify' component={ResumeModify}/>
            <Route exact path='/resume/read' component={ResumeRead}/>
            <Route exact path='/resume/register' component={ResumeRegister}/>

            {/*Funding*/}
            
            <Route exact path='/funding/list' component={FundingList}/>
            <Route exact path='/funding/modify/:update' component={FundingUpdate}/>
            <Route exact path='/funding/read/:read' component={FundingDetail}/>
            <Route exact path='/funding/register' component={FundingRegister}/>
            <Route exact path='/funding/home' component={FundingHome}/>

            {/*Item*/}
            <Route exact path='/item/item-list' component={ItemList}/>
            <Route exact path='/item/item-modify' component={ItemModify}/>
            <Route exact path='/item/item-read' component={ItemRead}/>
            <Route exact path='/item/item-register' component={ItemRegister}/>
         
            {/*Review*/}
            <Route exact path='/review/review-list' component={ReviewList}/>
            <Route exact path='/review/review-modify' component={ReviewModify}/>
            <Route exact path='/review/review-read' component={ReviewRead}/>
            <Route exact path='/review/review-register' component={ReviewRegister}/>

               {/*Work*/}
               <Route exact path='/work/work-list' component={WorkList}/>
               <Route exact path='/work/work-modify' component={WorkModify}/>
               <Route exact path='/work/work-read' component={WorkRead}/>
               <Route exact path='/work/work-register' component={WorkRegister}/>
          </Switch>
        </ScrollToTop>
      </ScrollIntoView>
    </Router>
  );
}

export default App;
