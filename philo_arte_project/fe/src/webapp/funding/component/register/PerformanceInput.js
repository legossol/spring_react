import React, {useCallback, useState} from 'react';
import TextField from '@material-ui/core/TextField';
import {Button, Grid, MenuItem} from "@material-ui/core";
import { FormControl } from '@material-ui/core';

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

    const hashtags = [
        {
            value:'약',
            label:'약'
        },
        {
            value:'건강기능',
            label:'건강기능'
        },
        {
            value:'여행',
            label:'여행'
        }

    ]

    return (
        
        <>
        <FormControl>
        <Grid
            container
            style={{display:"flex",justifyContent:"center"}}
            direction="row"
            justify="flex-start"
            alignItems="flex-start"
            spacing={3}
            
            >
            <Grid container xs="12" spacing="10"
            style={{display:"flex",justifyContent:"center"}}>

                <Grid item  sm={4}>
                <TextField   label="Title" color="secondary"  value={titleState} onChange={changeTitle} />
                </Grid>

                <Grid item sm={4}>
                <TextField label="GoalPrice" color="secondary" value={goalPriceState} onChange={changeGoalPrice}>$</TextField>
                </Grid>

                <Grid item sm ={3}>
                <TextField
                select
                label="Select Hashtag"
                value={hashtagState}
                onChange={changeHashtag}
                helperText="Please select your Funding Hashtag"
                variant="filled"
                >
                {hashtags.map((option) => (
                    <MenuItem key={option.value} value={option.value}>
                    {option.label}
                    </MenuItem>
                ))}
            </TextField>
            </Grid>
            
            </Grid>
            
           
            <hr/>
            <hr/>
            <Grid container xs="10" spacing="10"
            style={{display:"flex",justifyContent:"center"}}
            justify="flex-start"
            alignItems="flex-start">
            <TextField
                color="secondary" value={contentState} onChange={changeContent}
                id="outlined-multiline-static"
                label="상세 내용"
                multiline
                rows={30}
                fullWidth={10}
                defaultValue="펀딩 내용을 입력해주세요"
                variant="outlined"
            />
            </Grid>
            <Grid container xs={12} style={{marginLeft:40}} >
            <Grid item xs={4} sm={6}>
                <hr/>
            <TextField
              fullWidth
              multilineß
              
              style={{marginLeft:40}}
              value="당신의 펀딩을 알릴 사진을 등록해주세요"
              label="펀딩 사진"
              rows="6"
              defaultValue="Default Value"
            />

            </Grid>
            <Grid item xs={8} sm={8}style={{marginLeft:40}}>
            <Grid container>
              <Grid item>
                <TextField name="Popup_A1" fullWidth select />
              </Grid>
              <Grid item>
                <TextField name="Popup_A2" fullWidth select />
              </Grid>
            </Grid>
          </Grid>
            </Grid>
           
        </Grid>
        </FormControl>
        <Button onClick={sendForm}>SUBMIT</Button>
        </>
    );
};

export default PerformanceInput;

{/* <TextField id="standard-secondary" label="Title" color="secondary"  value={titleState} onChange={changeTitle}/>

<TextField id="standard-secondary" label="Content" color="secondary" value={contentState} onChange={changeContent}/>

<TextField id="standard-secondary" label="GoalPrice" color="secondary" value={goalPriceState} onChange={changeGoalPrice}/>

<TextField id="standard-secondary" label="Hashtag" color="secondary" value={hashtagState} onChange={changeHashtag}/> */}
