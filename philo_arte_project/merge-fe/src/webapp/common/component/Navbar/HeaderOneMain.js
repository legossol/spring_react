import React, { useEffect, useState } from 'react';
// DATA Files
import dataNavLogin from 'webapp/common/data/Navbar/main-navbar-login.json';
import dataNavbar from 'webapp/common/data/Navbar/main-navbar-data.json';

// components
import HeaderOne from 'webapp/common/Header/HeaderOne';

import Signin from 'webapp/artist/component/Signin';
import { useDispatch, useSelector } from 'react-redux';
import { getLocalArtist } from 'webapp/artist/reducer/artist.reducer';

const HeaderOneMain = () => {
    const dispatch = useDispatch()
    useEffect(()=>{
        dispatch(getLocalArtist())
    })
    const artistState = useSelector(state=> state.artists.artistsState);
    console.log(artistState,"artistState-=========")
    return (
        <>
            <div>
                <HeaderOne data={ artistState.username != undefined && artistState.username != "" ? dataNavLogin : dataNavbar} />
            </div>
        </>
    );
};
export default HeaderOneMain;