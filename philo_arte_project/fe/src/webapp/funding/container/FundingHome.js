import React from "react";
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import dataServices from "webapp/common/data/Services/services-studio-data.json";
import dataSkills from "webapp/common/data/Skills/skills-data.json";
import dataCounters from "webapp/common/data/Counters/counters-data.json";

import dataPortfolio from "webapp/common/data/Portfolio/main-portfolio-data.json";
import dataTestimonials from "webapp/common/data/Testimonials/testimonials-data.json";
import dataClients from "webapp/common/data/Clients/clients-data.json";
import dataBlog from "webapp/common/data/Blog/blog-data.json";
import dataTabs from "webapp/common/data/Tabs/tabs-data.json";
// Images
import imgParallax from "webapp/images/background/sampleImg.jpg";
import imageVideo from "webapp/images/video-mockup.png";
// Components
import TabsTwo from "webapp/funding/component/showing/TabsTwo";
import PortfolioOne from "webapp/common/Portfolio/PortfolioOne";
import HeaderSocial from "webapp/common/Header/HeaderSocial";
import HomeDigitalSlider from "webapp/common/HeroSlider/HomeDigitalSlider";
import HomeMarketingSlider from "webapp/common/HeroSlider/HeroMarketing";
import FooterOne from "webapp/common/Footer/FooterOne";
import WhatWeOfferThree from "webapp/common/WhatWeOffer/WhatWeOfferThree";
import WhatWeOfferEight from "webapp/common/WhatWeOffer/WhatWeOfferEight";
import PresentationOne from "webapp/funding/component/showing/PresentationOne";
import AboutTwo from "webapp/funding/component/showing/AboutTwo";
import CounterRowOne from "webapp/common/Counters/CounterRowOne";
import ParallaxTwo from "webapp/funding/component/showing/ParallaxTwo";
import PortfolioBoxedSpaceThree from "webapp/funding/component/showing/PortfolioBoxedSpaceThree";
import TestimonialsThree from "webapp/funding/component/showing/TestimonialsTwo";
import ClientsGrid from "webapp/common/Carousel/ClientsCarousel";
import BlogSection from "webapp/funding/component/showing/BlogSection";
import FundingList from "../component/FundingList"

import Loader from "webapp/common/Loader/Loader";

const FundingHome = () => (
  <>
 
    <HeaderSocial data={dataNavbar} />

    <HomeMarketingSlider />
    <PortfolioOne
      tagline="Let's participate Funding"
      title="당신이 함께 할 수 있는 펀딩리스트"
      backfont="FUND"
      classes="no-bottom-line"
      data={dataPortfolio}
      filter={true}
      categories={[
        "도자기",
        "수채화",
        "동양화",
        "서양화",
        "추상화",
      ]}
    />
    
    <TestimonialsThree data={dataTestimonials} title="Our Artist Says">
      <ClientsGrid data={dataClients} classes="mt-100" />
    </TestimonialsThree>
    <BlogSection title="종료 된 펀딩" data={dataBlog} />
   
    <FooterOne />
  </>
);

export default FundingHome;
