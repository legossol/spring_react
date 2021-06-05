
import React, { useEffect } from 'react';
import { makeStyles, createStyles, Theme } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import IconButton from "@material-ui/core/IconButton";
import FavoriteIcon from "@material-ui/icons/Favorite";
import ListIcon from "@material-ui/icons/List";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import { useDispatch, useSelector } from 'react-redux';
import { currentFunding, dududududududu, getFundingList,getFundingDetail } from '../reducer/funding.reducer';
import { keys } from '@material-ui/core/styles/createBreakpoints';
import { Input } from '@material-ui/core';
import { Link } from 'react-router-dom';

const FundingListForm = ({fundingId,title,content,hashtag, image,goalPrice}) => {
    const param = useSelector(currentFunding)
    const dispatch = useDispatch()
    // const selectContent = fundingId =>{
    //     console.log("SElect이동!!!!!(!#*(!#*(!#*(!#*(!&*#("+ fundingId)
    //     dispatch(getFundingDetail(fundingId))
    //   }
    const useStyles = makeStyles((theme) => ({
      root: {
        flexGrow: 1,
      },
      paper: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary,
      },
    }));
    const classes = useStyles();
    const imageBox =image.map(image=>{
      return(
      image.map ?
          <img  key={image.fundingId} src={`http://localhost:8080/funding_file/display?fileName=
          ${image.uuid+"_"+image.fname}`}/> :<></>
      )})
console.log("index of image",image)
console.log("index of Fist Image",image[0])
console.log("imageBox ====", imageBox)
  return (
      <>
      
      <Grid
            container
            style={{display:"flex",justifyContent:"center"}}
            direction="row"
            // justify="space-between"
            // alignItems="center"
            spacing={3}
            
            >
              
      <Grid container item xs={6}  sm={3} lg={4}   >
        <Card direction="row" >
          <CardActionArea>
            {/* <CardMedia
              component="img"
              height="140"
              title={title}
            /> */}
             <Typography
              gutterBottom
              style={{display:"flex",justifyContent:"center"}}
              variant="h5"
              component="h2"
              noWrap
              >{title}</Typography>
            {image.map((image,i)=>(
             
              <CardMedia>
              <img key={i} src={`http://localhost:8080/funding_file/display?fileName=${image.uuid}_${image.fname}`}/>
                
              </CardMedia>
                )
            )}
             {content}
            <CardContent>
              <Typography
                gutterBottom
                variant="h5"
                component="h2"
                noWrap
              >
              
              </Typography>
              <Typography variant="body2" color="textSecondary" noWrap>
              
                <Button
                  variant="outlined"
                  size="small"
                  color="primary"
                >
                    {hashtag}
                </Button>
                <Link to ={`/funding/modify/${fundingId}`} >
                <Button
                  variant="outlined"
                  size="small"
                  color="primary"
                  key={param.fundingId}
                  onClick={()=>dispatch(getFundingDetail(fundingId))}
                >
                    수정하기
                </Button>
                </Link>
                <Typography color="initial" align="right">
                  목표 금액 :  <Input defaultValue={goalPrice} error inputProps={{ 'aria-label': 'description' }} />
                </Typography>

                {/* <Typography color="secondary" align="right">
                  달성률: $80
                </Typography> */}
              </Typography>
            </CardContent>
          </CardActionArea>


        </Card>
      </Grid>
      
      
      </Grid>
    <hr/>
    
    </>
  );
}

export default FundingListForm;