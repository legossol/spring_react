import React from "react";
// DATA Files
import dataNavbar from "../../webapp/data/Navbar/home-business-navbar.json";
import dataBlog from "../../webapp/data/Blog/blog-data.json";
// Images
import imgTitle from "../../webapp/assets/images/title-bg/title-bg-2.jpg";
// Components
import HeaderOne from "../../webapp/common/Header/HeaderOne";
import PageTitleOne from "../../webapp/common/PageTitle/PageTitleOne";
import BlogContent from "../../webapp/common/Blog/BlogContent";
import FooterTwo from "../../webapp/common/Footer/FooterTwo";

const BlogDetailsPage = () => (
  <>
    <HeaderOne data={dataNavbar} />
    <PageTitleOne title="Blog Details" image={imgTitle} />
    <BlogContent post={dataBlog[1]} data={dataBlog} />
    <FooterTwo />
  </>
);

export default BlogDetailsPage;
