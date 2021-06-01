import React, {useRef} from 'react';
import {Button} from "@material-ui/core";
import axios from "axios";
import PerformanceInput from './register/PerformanceInput';
import UploadInput from './register/UploadInput';
import HeaderSocial from 'webapp/common/Header/HeaderSocial'
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import HomeMarketingSlider from "webapp/funding/component/showing/HeroMarketing";

const FundingRegister = ({requestRefresh}) => {


    const childRef = useRef()
    let uploadedFiles = null

    const sendTextForm = (title, content, goalPrice, hashtag) => {
        console.log("title: " + title)
        console.log("content: " + content)
        childRef.current.send()
        console.log(uploadedFiles)


        const data = {title:title, content:content, goalPrice:goalPrice, hashtag:hashtag, pictures:uploadedFiles}

        axios.post("http://localhost:8080/funding/register", data)
        .then(res => {
            console.log(res.data)
            requestRefresh()
        })

    }

    const getUploadedFiles = (uplodedFilesResult) => {
        console.log("getUploadedFiles")
        uploadedFiles = uplodedFilesResult
    }


    return (
        <div>
            <HeaderSocial data={dataNavbar} />
              <HomeMarketingSlider/>
            <div style={{marginLeft:100}}>
                <h2>펀딩 등록</h2>
            </div>
            <hr/>

            <PerformanceInput sendTextForm = {sendTextForm}></PerformanceInput>
            <hr/>
            <UploadInput cref={childRef} getUploadedFiles = {getUploadedFiles}></UploadInput>

        </div>
    );
};

export default FundingRegister

