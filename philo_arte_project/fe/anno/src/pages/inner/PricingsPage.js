import React from "react";
// DATA Files
import dataNavbar from "../../data/Navbar/home-business-navbar.json";
import dataPricings from "../../data/Pricings/pricings-data.json";
// Images
import imgTitle from "../../assets/images/title-bg/title-bg-4.jpg";
// Components
import HeaderOne from "../../webapp/common/Header/HeaderOne";
import PageTitleTwo from "../../webapp/common/PageTitle/PageTitleTwo";
import PricingsRowOne from "../../webapp/common/Pricings/PricingsRowOne";
import FooterTwo from "../../webapp/common/Footer/FooterTwo";

const PricingsPage = () => (
  <>
    <HeaderOne data={dataNavbar} />
    <PageTitleTwo title="Pricing" image={imgTitle} />
    <PricingsRowOne data={dataPricings} />
    <FooterTwo />
  </>
);

export default PricingsPage;
