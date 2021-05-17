import React from "react";
// DATA Files
import dataNavbar from "../../webapp/data/Navbar/home-business-navbar.json";
import dataSlider from "../../webapp/data/Slider/home-business-data.json";
import dataServices from "../../webapp/data/Services/services-business.json";
import dataProcess from "../../webapp/data/Process/process-data.json";
import dataTestimonials from "../../webapp/data/Testimonials/testimonials-data.json";
import dataPortfolio from "../../webapp/data/Portfolio/main-portfolio-data.json";
import dataBlog from "../../webapp/data/Blog/blog-data.json";
import dataTeam from "../../webapp/data/Team/team-sm-data.json";
import dataClients from "../../webapp/data/Clients/clients-data.json";
// Images
import imgWhatWeDo from "../../webapp/assets/images/bg-right-img.jpg";
import imgAbout from "../../webapp/assets/images/bg-left-img-2.jpg";
import imgParallax from "../../webapp/assets/images/background/parallax-bg-2.jpg";
// Components
import HeaderOne from "../../webapp/common/Header/HeaderOne";
import FooterTwo from "../../webapp/common/Footer/FooterTwo";
import HeroBusinessSlider from "../../webapp/common/HeroSlider/HeroBusinessSlider";
import WhatWeOfferFive from "../../webapp/common/WhatWeOffer/WhatWeOfferFive";
import WhatWeDoOne from "../../webapp/common/WhatWeDo/WhatWeDoOne";
import AboutThree from "../../webapp/common/About/AboutThree";
import ProcessThree from "../../webapp/common/Process/ProcessThree";
import TestimonialsOne from "../../webapp/common/Testimonials/TestimonialsOne";
import ParallaxTwo from "../../webapp/common/ParallaxSection/ParallaxTwo";
import PortfolioOne from "../../webapp/common/Portfolio/PortfolioOne";
import BlogCarousel from "../../webapp/common/Blog/BlogCarousel";
import TeamThree from "../../webapp/common/Team/TeamThree";
import ContactOne from "../../webapp/common/Contact/ContactOne";
import ClientsCarousel from "../../webapp/common/Carousel/ClientsCarousel";
import Loader from "../../webapp/common/Loader/Loader";

const HomeBusiness = () => (
  <Loader>
    <HeaderOne data={dataNavbar} border={true} />
    <HeroBusinessSlider data={dataSlider} />
    <WhatWeOfferFive
      tagline="Who We Are"
      title="We Craft Digital <br />Experience"
      data={dataServices}
    />
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
    <AboutThree
      tagline="About Us"
      title="Partners for Growth"
      image={imgAbout}
      pathBtn={process.env.PUBLIC_URL}
      video="https://www.youtube.com/watch?v=sU3FkzUKHXU"
    >
      The process of improving some measure of an enterprise's success. Business
      growth can be achieved either by boosting the top line or revenue of the
      business with greater product sales or service income, or by increasing
      the bottom line or profitability of the operation by minimizing costs.
    </AboutThree>
    <ProcessThree
      tagline="Our Steps"
      title="Work Together <br>For Success"
      backfont="Steps"
      data={dataProcess}
    />
    <TestimonialsOne
      tagline="What Client Says"
      title="Our Happy Customers"
      backfont="Client"
      data={dataTestimonials}
    />
    <ParallaxTwo
      title="Let Your Email Address Speak for You"
      tagline="Join us on social media"
      textBtn="Read more"
      pathBtn={process.env.PUBLIC_URL}
      image={imgParallax}
    />
    <PortfolioOne
      tagline="Show Your Works"
      title="Our Portfolio"
      backfont="Works"
      classes="no-bottom-line"
      data={dataPortfolio}
    />
    <BlogCarousel
      tagline="Most Recent Articles"
      title="Our Latest Blogs"
      data={dataBlog}
    />
    <TeamThree tagline="Meet Creatives" title="Our Team" data={dataTeam} />
    <ContactOne
      tagline="Contact Us"
      title="Request a Quote Now"
      classes="no-bottom-line"
    />
    <ClientsCarousel data={dataClients} />
    <FooterTwo />
  </Loader>
);

export default HomeBusiness;
