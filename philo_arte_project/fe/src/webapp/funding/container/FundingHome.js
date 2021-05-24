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

import Loader from "webapp/common/Loader/Loader";

const FundingHome = () => (
  <>
 
    <HeaderSocial data={dataNavbar} />

    <HomeMarketingSlider />
    <PortfolioOne
      tagline="Show Your Works"
      title="Our Portfolio"
      backfont="Works"
      classes="no-bottom-line"
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

    <WhatWeOfferThree data={dataServices} />
    <PresentationOne
      title="Superb Website Template <br /> for Startups & Small Businesses."
      text="We Are provide web design services to startups and existing business in<br> New York and around the US helping them make an impact online."
      textBtn="Read more"
      pathBtn={process.env.PUBLIC_URL}
    />
    <AboutTwo
      title="Agency Overview"
      data={dataSkills}
      text='<p class="mt-30">
            Every site we create is designed and optimised to look and function
            just as well on mobile phones and tablets as it does on a desktop,
            creating a seamless experience across any device.
          </p>
          <p>
            We use the latest development standards and web technologies to keep
            things cutting edge, ensuring your new website is built on a stable
            and future-proof foundation.
          </p>'
    >
      <CounterRowOne data={dataCounters} classes="mt-50" />
    </AboutTwo>
    <ParallaxTwo
      title="Let Your Email Address Speak for You"
      tagline="Join us on social media"
      textBtn="Read more"
      pathBtn="!#"
      typeBtn="btn-lg btn-color btn-circle"
      image={imgParallax}
    />
    <PortfolioBoxedSpaceThree
      title="Our Latest Works"
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
    <TestimonialsThree data={dataTestimonials} title="Our Clients Say">
      <ClientsGrid data={dataClients} classes="mt-100" />
    </TestimonialsThree>
    <BlogSection title="Our Latest Blogs" data={dataBlog} />
   
    <FooterOne />
  </>
);

export default FundingHome;
