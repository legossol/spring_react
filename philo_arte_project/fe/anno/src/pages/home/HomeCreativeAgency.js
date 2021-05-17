import React from "react";
// DATA Files
import dataNavbar from "../../data/Navbar/creative-agency-navbar.json";
import dataTabs from "../../data/Tabs/tabs-data.json";
import dataPortfolio from "../../data/Portfolio/masonry-portfolio-data.json";
import dataProcess from "../../data/Process/process-data.json";
import dataTestimonials from "../../data/Testimonials/testimonials-data.json";
import dataTeam from "../../data/Team/team-data.json";
import dataPricings from "../../data/Pricings/pricings-data.json";
import dataClients from "../../data/Clients/clients-data.json";
// Images
import imgOffer from "../../assets/images/video-mockup.png";
import imgParallax from "../../assets/images/background/parallax-bg-2.jpg";
// Components
import HeaderTwo from "../../webapp/common/Header/HeaderTwo";
import FooterOne from "../../webapp/common/Footer/FooterOne";
import HeroCreativeAgency from "../../webapp/common/HeroSlider/HeroCreativeAgency";
import WhatWeOfferTwo from "../../webapp/common/WhatWeOffer/WhatWeOfferTwo";
import TabsOne from "../../webapp/common/Tabs/TabsOne";
import PortfolioTwo from "../../webapp/common/Portfolio/PortfolioTwo";
import ProcessOne from "../../webapp/common/Process/ProcessOne";
import TestimonialsTwo from "../../webapp/common/Testimonials/TestimonialsTwo";
import TeamTwo from "../../webapp/common/Team/TeamTwo";
import ParallaxTwo from "../../webapp/common/ParallaxSection/ParallaxTwo";
import PricingsOne from "../../webapp/common/Pricings/PricingsOne";
import ContactTwo from "../../webapp/common/Contact/ContactTwo";
import ClientsGrid from "../../webapp/common/Carousel/ClientsGrid";
import Loader from "../../webapp/common/Loader/Loader";

const HomeCreativeAgency = () => (
  <Loader>
    <HeaderTwo type="wide" data={dataNavbar} />
    <HeroCreativeAgency />
    <WhatWeOfferTwo
      title='We Design Visual Experience <br /> for The <span class="text-bottom-line-sm">Web</span>'
      text="Anno template provides fully flexible templates, allowing to
              customize every page and section down to the tiniest detail in a
              few clicks!"
      image={imgOffer}
      video="https://www.youtube.com/watch?v=sU3FkzUKHXU"
    >
      <TabsOne data={dataTabs} classes="mt-50" />
    </WhatWeOfferTwo>
    <PortfolioTwo
      title='Take a Look at Our Featured <span class="text-bottom-line-sm">Work</span>'
      data={dataPortfolio}
    />
    <ProcessOne data={dataProcess} />
    <TestimonialsTwo
      title='Our<br /> Happy <span class="text-bottom-line-sm">Customers</span>'
      data={dataTestimonials}
    />
    <TeamTwo
      data={dataTeam}
      title={
        'Our Warm Up <br /> Is Your <span class="text-bottom-line-sm">Work Out</span>'
      }
    />
    <ParallaxTwo
      title="Let Your Email Address Speak for You"
      tagline="Join us on social media"
      textBtn="Read more"
      pathBtn="!#"
      image={imgParallax}
    />
    <PricingsOne
      data={dataPricings}
      title='Panoramic Solutions<br /> Top <span class="text-bottom-line-sm">To Bottom</span>'
      titleAlign="left"
    />
    <ContactTwo title='Request a Quote <span class="text-bottom-line-sm">Now</span>'>
      <ClientsGrid data={dataClients} />
    </ContactTwo>
    <FooterOne />
  </Loader>
);

export default HomeCreativeAgency;
