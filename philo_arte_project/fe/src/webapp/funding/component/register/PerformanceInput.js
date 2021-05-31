import React, {useCallback, useState} from 'react';
import TextField from '@material-ui/core/TextField';
import {Button} from "@material-ui/core";

const PerformanceInput = ({pno, title ='', content ='',goalPrice='',hashtag='', regDate, modDate, sendTextForm}) => {

    const [titleState, setTitleState] = useState(title)
    const [contentState, setContentState] = useState(content)
    const [goalPriceState, setGoalPriceState] = useState(goalPrice)
    const [hashtagState, setHashtagState] = useState(hashtag)

    const changeTitle = useCallback(e => {
        setTitleState(e.target.value)
    });

    const changeContent = useCallback(e => {
        setContentState(e.target.value)
    });
    const changeGoalPrice = useCallback(e => {
        setGoalPriceState(e.target.value)
    });
    const changeHashtag = useCallback(e => {
        setHashtagState(e.target.value)
    });

    const sendForm = useCallback(e => {
        sendTextForm(titleState, contentState,goalPriceState,hashtagState)
        setTitleState('')
        setContentState('')
        setGoalPriceState('')
        setHashtagState('')
    })


    return (
        <form>
            <TextField id="standard-secondary" label="Title" color="secondary"  value={titleState} onChange={changeTitle}/>

            <TextField id="standard-secondary" label="Content" color="secondary" value={contentState} onChange={changeContent}/>
            
            <TextField id="standard-secondary" label="GoalPrice" color="secondary" value={goalPriceState} onChange={changeGoalPrice}/>
            
            <TextField id="standard-secondary" label="Hashtag" color="secondary" value={hashtagState} onChange={changeHashtag}/>

            <Button onClick={sendForm}>SUBMIT</Button>

        </form>
    );
};

export default PerformanceInput;