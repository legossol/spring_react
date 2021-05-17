import React from "react";
// DATA Files
import dataNavbar from "../../webapp/data/Navbar/home-business-navbar.json";
import dataTestimonials from "../../webapp/data/Testimonials/testimonials-data.json";
// Images
import imgTitle from "../../webapp/assets/images/title-bg/title-bg-1.jpg";
// Components
import HeaderOne from "../../webapp/common/Header/HeaderOne";
import PageTitleTwo from "../../webapp/common/PageTitle/PageTitleTwo";
import TestimonialsTwo from "../../webapp/common/Testimonials/TestimonialsTwo";
import TestimonialsOne from "../../webapp/common/Testimonials/TestimonialsOne";
import FooterTwo from "../../webapp/common/Footer/FooterTwo";

const TestimonialsPage = () => (
  <>
    <HeaderOne data={dataNavbar} />
    <PageTitleTwo title="Our Testimonials" image={imgTitle} />
    <TestimonialsTwo
      title='Our<br /> Happy <span class="text-bottom-line-sm">Customers</span>'
      data={dataTestimonials}
      type="dark"
    />
    <TestimonialsOne data={dataTestimonials} />
    <FooterTwo />
  </>
);

export default TestimonialsPage;
