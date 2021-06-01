import React, {useCallback, useState} from 'react';
import TextField from '@material-ui/core/TextField';
import {Button} from "@material-ui/core";
const TextRegister = () => {
    const [funding, setNewFunding] = useState({
        title : "",
        content : "",
        goalPrice : "",
        viewCnt:"",
        hashtag : "",
        artistId:""
    })
    const handleSubmit = useCallback(e =>{
        const {name, value} = e.target
        setNewFunding({
            ...funding,
            [name]: value
        })
    },[funding])
    
    return(
        <>
         <Form>
      <Grid
        container
        direction="row"
        justify="flex-start"
        alignItems="flex-start"
        spacing={1}
      >
        Form
        <Grid container xs="12" spacing="1">
          <Grid item>
            <TextField name="Field1" value="Field1" />
          </Grid>
          <Grid item>
            <TextField name="Field2" value="Field2" />
          </Grid>
        </Grid>
        <Grid container xs={12}>
          <Grid item xs={4} sm={4}>
            <TextField
              fullWidth
              multilineß
              value="Field1"
              label="Multiline"
              rows="6"
              defaultValue="Default Value"
            />
          </Grid>
          <Grid item xs={8} sm={8}>
            <Grid container>
              <Grid item>
                <TextField name="Popup_A1" fullWidth select />
              </Grid>
              <Grid item>
                <TextField name="Popup_A2" fullWidth select />
              </Grid>
            </Grid>
            <Grid container>
              <Grid item>
                <TextField name="Popup_A1" fullWidth select />
              </Grid>
              <Grid item>
                <TextField name="Popup_A2" fullWidth select />
              </Grid>
            </Grid>
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
    </Form>
        <h1>아 이 템 등 록 하 기</h1>
        <form >
            
            <label>title</label>
            <input type='text' style={{color:'black'}} name='title' value={funding.title} />
            <hr/>
            <label>content</label>
            <input type="text"style={{color:'black'}} name="content" value={funding.content} />
            <hr/>
            <label>목표금액</label>
            <input type="number"style={{color:'black'}} name="goalPrice" value={funding.goalPrice} />
            <label>해쉬태그</label>
            <input type="text" style={{color:'black'}}name="hashtag" value={funding.hashtag} />
            <label>viewCnt</label>
            <input type="number"style={{color:'black'}} name="viewCnt" value={funding.viewCnt} />
            <label>artistId</label>
            <input type="number"style={{color:'black'}} name="artistId" value={funding.artistId} />
            <hr/>
            <Button onClick={handleSubmit}>SUBMIT</Button>
        </form>
       
        </>
    )
}

export default TextRegister