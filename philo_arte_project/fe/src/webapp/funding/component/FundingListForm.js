
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
    console.log("image느느느느느느느========="+JSON.stringify(image))
    // const selectContent = fundingId =>{
    //     console.log("SElect이동!!!!!(!#*(!#*(!#*(!#*(!&*#("+ fundingId)
    //     dispatch(getFundingDetail(fundingId))
    //   }

  return (
      <>
      
      <Grid
            container
            style={{display:"flex",justifyContent:"center"}}
            direction="row"
            justify="flex-start"
            alignItems="flex-start"
            spacing={3}
            
            >
      <Grid item xs={6} sm={4} lg={8}   >
        <Card>
          <CardActionArea>
            <CardMedia
              component="img"
              height="140"
              src=""
              title={title}
            />
           
            {image.map((image,i)=>(
                <div key={i}>
                    <img src={`http://localhost:8080/funding_file/display?fileName=${image.uuid}_${image.fname}`}/>
                </div>
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
                  onClick={()=>dispatch(getFundingDetail(fundingId))}
                >
                    {hashtag}
                </Button>
                <Link to ={`/funding/modify/${fundingId}`} >
                <Button
                  variant="outlined"
                  size="small"
                  color="primary"
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