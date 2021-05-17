import React from "react";
// DATA Files
import dataNavbar from "../../webapp/data/Navbar/main-navbar-data.json";
import dataServices from "../../webapp/data/Services/services-imagebg-data.json";
import dataPortfolio from "../../webapp/data/Portfolio/masonry-portfolio-data.json";
import dataCounters from "../../webapp/data/Counters/counters-data.json";
import dataTestimonials from "../../webapp/data/Testimonials/testimonials-data.json";
import dataTeam from "../../webapp/data/Team/team-data.json";
import dataPricings from "../../webapp/data/Pricings/pricings-data.json";
import dataClients from "../../webapp/data/Clients/clients-data.json";
// Images
import imgHero from "../../webapp/assets/images/slides/home-bg-18.jpg";
import imgAbout from "../../webapp/assets/images/bg-left-img.jpg";
import imgWhatWeDo from "../../webapp/assets/images/bg-right-img.jpg";
import imgParallax from "../../webapp/assets/images/background/parallax-bg.jpg";
// Components
import HeaderOne from "../../webapp/common/Header/HeaderOne";
import HeroHomeImageBg from "../../webapp/common/HeroSlider/HeroHomeImageBg";
import WhatWeOfferTen from "../../webapp/common/WhatWeOffer/WhatWeOfferTen";
import CountersOne from "../../webapp/common/Counters/CountersOne";
import AboutSix from "../../webapp/common/About/AboutSix";
import WhatWeDoOne from "../../webapp/common/WhatWeDo/WhatWeDoOne";
import TestimonialsOne from "../../webapp/common/Testimonials/TestimonialsOne";
import TeamOne from "../../webapp/common/Team/TeamOne";
import ParallaxOne from "../../webapp/common/ParallaxSection/ParallaxOne";
import PricingsOne from "../../webapp/common/Pricings/PricingsOne";
import ContactOne from "../../webapp/common/Contact/ContactOne";
import ClientsCarousel from "../../webapp/common/Carousel/ClientsCarousel";
import FooterTwo from "../../webapp/common/Footer/FooterTwo";
import PortfolioWideMasonry from "../../webapp/common/Portfolio/PortfolioWideMasonry";
import Loader from "../../webapp/common/Loader/Loader";

const HomeImageBg = () => (
  <Loader>
    <HeaderOne data={dataNavbar} />
    <HeroHomeImageBg
      title='Custom Solutions for<br />
    <span class="text-bottom-line">Digital</span> Marketing'
      image={imgHero}
    />
    <WhatWeOfferTen
      data={dataServices}
      tagline="Our Core Services"
      title="We Craft Digital <br />Experience"
    />
    <PortfolioWideMasonry
        tagline="Show Your Works"
        title="Our Portfolio"
        data={dataPortfolio}
        filter={true}
        categories={[
          "Branding",
          "Creative Design",
          "Web Design",
          "Stationery",
          "Photography",
        ]}
      />
    <CountersOne data={dataCounters} type="dark" />
    <AboutSix
      tagline="About Us"
      title="Partners for Growth"
      backfont="Partners"
      image={imgAbout}
      pathBtn={process.env.PUBLIC_URL}
      video="https://www.youtube.com/watch?v=sU3FkzUKHXU"
    >
      The process of improving some measure of an enterprise's success. Business
      growth can be achieved either by boosting the top line or revenue of the
      business with greater product sales or service income, or by increasing
      the bottom line or profitability of the operation by minimizing costs.
    </AboutSix>
    <WhatWeDoOne
      tagline="What We Do"
      title="Digital Services"
      image={imgWhatWeDo}
      classes="no-bottom-line"
    >
      The term Digital Services refers to the electronic delivery of information
      including data and content across multiple platforms and devices like web
      or mobile. Information is presented in a way that is easy to use and
      understand and typically involves transactional services such as
      submitting forms for processing and receiving benefits.
    </WhatWeDoOne>
    <TestimonialsOne data={dataTestimonials} />
    <TeamOne tagline="Meet Creatives" title="Our Team" data={dataTeam} />
    <ParallaxOne image={imgParallax}>
      Where something special happens every days
    </ParallaxOne>
    <PricingsOne
      tagline="Select Your Plan"
      title="Our Pricing"
      data={dataPricings}
      dashColor="dark"
    />
    <ContactOne
      title='Request a Quote <span class="text-bottom-line-sm">Now</span>'
      tagline="Contact Us"
    />
    <ClientsCarousel data={dataClients} />
    <FooterTwo />
  </Loader>
);

export default HomeImageBg;
