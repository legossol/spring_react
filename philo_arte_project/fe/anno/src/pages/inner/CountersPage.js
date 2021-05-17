import React from "react";
// DATA Files
import dataNavbar from "../../webapp/data/Navbar/home-business-navbar.json";
import dataCounters from "../../webapp/data/Counters/counters-data.json";
import dataCountersTwo from "../../webapp/data/Counters/counters-two-data.json";
// Images
import imgTitle from "../../webapp/assets/images/title-bg/title-bg-1.jpg";
// Components
import HeaderOne from "../../webapp/common/Header/HeaderOne";
import PageTitleOne from "../../webapp/common/PageTitle/PageTitleOne";
import CountersThree from "../../webapp/common/Counters/CountersThree";
import CountersFour from "../../webapp/common/Counters/CountersFour";
import CountersFive from "../../webapp/common/Counters/CountersFive";
import CountersSix from "../../webapp/common/Counters/CountersSix";
import FooterTwo from "../../webapp/common/Footer/FooterTwo";

const CountersPage = () => (
  <>
    <HeaderOne data={dataNavbar} />
    <PageTitleOne title="Counters" image={imgTitle} />
    <CountersThree
      data={dataCountersTwo}
      title="We Craft Digital <br />Experience"
      tagline="Counter Style One"
    />
    <CountersFour
      data={dataCountersTwo}
      title="We Craft Digital <br />Experience"
      tagline="Counter Style Two"
    />
    <CountersFive
      data={dataCounters}
      title="We Craft Digital <br />Experience"
      tagline="Counter Style Three"
    />
    <CountersSix
      data={dataCountersTwo}
      title="We Craft Digital <br />Experience"
      tagline="Counter Style Four"
    />
    <FooterTwo />
  </>
);

export default CountersPage;
