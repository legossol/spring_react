import React from "react";
// DATA Files
import dataNavbar from "../../data/Navbar/home-business-navbar.json";
// Images
import imgTitle from "../../assets/images/title-bg/title-bg-3.jpg";
// Components
import HeaderOne from "../../webapp/common/Header/HeaderOne";
import PageTitleOne from "../../webapp/common/PageTitle/PageTitleOne";
import CountdownOne from "../../webapp/common/Countdown/CountdownOne";
import CountdownTwo from "../../webapp/common/Countdown/CountdownTwo";
import CountdownThree from "../../webapp/common/Countdown/CountdownThree";
import CountdownFour from "../../webapp/common/Countdown/CountdownFour";
import FooterTwo from "../../webapp/common/Footer/FooterTwo";

const CountdownPage = () => (
  <>
    <HeaderOne data={dataNavbar} />
    <PageTitleOne title="Countdown" image={imgTitle} />
    <CountdownOne
      title="We Craft Digital <br />Experience"
      tagline="Countdown Style One"
    />
    <CountdownTwo
      title="We Craft Digital <br />Experience"
      tagline="Countdown Style Two"
    />
    <CountdownThree
      title="We Craft Digital <br />Experience"
      tagline="Countdown Style Three"
    />
    <CountdownFour
      title="We Craft Digital <br />Experience"
      tagline="Countdown Style Four"
    />
    <FooterTwo />
  </>
);

export default CountdownPage;
