import React from "react";
// CSS
import "./../../../node_modules/react-rev-slider/src/rs-plugin/css/settings.css";
import "./../../webapp/assets/css/revolution/settings.css";
import "./../../webapp/assets/css/revolution/layers.css";
import "./../../webapp/assets/css/revolution/navigation.css";
// DATA Files
import dataNavbar from "../../webapp/data/Navbar/home-marketing-navbar.json";
import dataTabs from "../../webapp/data/Tabs/tabs-data.json";
import dataPortfolio from "../../webapp/data/Portfolio/masonry-portfolio-data.json";
import dataProcess from "../../webapp/data/Process/process-marketing-data.json";
import dataTestimonials from "../../webapp/data/Testimonials/testimonials-data.json";
import dataClients from "../../webapp/data/Clients/clients-data.json";
import dataTeam from "../../webapp/data/Team/team-data.json";
import dataBlog from "../../webapp/data/Blog/blog-data.json";
// Images
import imageVideo from "../../webapp/assets/images/video-mockup.png";
import imageAbout from "../../webapp/assets/images/bg-left-img-2.jpg";
import imgParallax from "../../webapp/assets/images/background/parallax-bg-2.jpg";
// Components
import HeaderOne from "../../webapp/common/Header/HeaderOne";
import HeroMarketing from "../../webapp/common/HeroSlider/HeroMarketing";
import TabsTwo from "../../webapp/common/Tabs/TabsTwo";
import WhatWeOfferEight from "../../webapp/common/WhatWeOffer/WhatWeOfferEight";
import ProcessSix from "../../webapp/common/Process/ProcessSix";
import AboutFour from "../../webapp/common/About/AboutFour";
import TestimonialsFive from "../../webapp/common/Testimonials/TestimonialsFive";
import ClientsGrid from "../../webapp/common/Carousel/ClientsGrid";
import TeamSix from "../../webapp/common/Team/TeamSix";
import ParallaxTwo from "../../webapp/common/ParallaxSection/ParallaxTwo";
import BlogSectionTwo from "../../webapp/common/Blog/BlogSectionTwo";
import ContactSix from "../../webapp/common/Contact/ContactSix";
import FooterOne from "../../webapp/common/Footer/FooterOne";
import PortfolioWideMasonry from "../../webapp/common/Portfolio/PortfolioWideMasonry";
import Loader from "../../webapp/common/Loader/Loader";

const HomeMarketing = () => (
  <Loader>
    <HeaderOne data={dataNavbar} />
    <HeroMarketing />
    <WhatWeOfferEight
      title="We Design Visual Experience for The Web"
      text="Anno template provides fully flexible templates, allowing to
    customize every page and section down to the tiniest detail in a
    few clicks!"
      image={imageVideo}
      video="https://www.youtube.com/watch?v=sU3FkzUKHXU"
    >
      <TabsTwo data={dataTabs} />
    </WhatWeOfferEight>
    <PortfolioWideMasonry data={dataPortfolio} classes="pt-0" />
    <ProcessSix data={dataProcess} />
    <AboutFour
      title="Partners for Growth"
      text="The process of improving some measure of an enterprise's success.
        Business growth can be achieved either by boosting the top line or
        revenue of the business with greater product sales or service income,
        or by increasing the bottom line or profitability of the operation by
        minimizing costs."
      image={imageAbout}
    />
    <TestimonialsFive title="Our Happy Customers" data={dataTestimonials}>
      <ClientsGrid data={dataClients} classes="mt-100" />
    </TestimonialsFive>
    <TeamSix data={dataTeam} title="You Are Only Good <br /> As Your Team" />
    <ParallaxTwo
      title="Let Your Email Address Speak for You"
      tagline="Join us on social media"
      textBtn="Read more"
      pathBtn={process.env.PUBLIC_URL}
      image={imgParallax}
    />
    <BlogSectionTwo title="Our Latest Blogs" data={dataBlog} />
    <ContactSix />
    <FooterOne />
  </Loader>
);

export default HomeMarketing;
