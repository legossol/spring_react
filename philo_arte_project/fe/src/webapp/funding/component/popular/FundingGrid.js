import React from 'react';
import FundingList from '../FundingList'

import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import Itemhandle from './Itemhandle';
const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    paper: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary,
        overflow: "scroll",
        maxHeight: "100vh",
        display: 'flex'
    },
}));
const FundingGrid = () =>{
    const classes = useStyles();
    return (
        <div className={classes.root}>
        <Grid container spacing={3}>
            <Grid item xs={8}>
                <Paper className={classes.paper}>
                    <Itemhandle></Itemhandle>
                </Paper>
            </Grid>
            <Grid item xs={4}>
                <Paper className={classes.paper}>xs=12</Paper>
            </Grid>
        </Grid>
    </div>

    )
}