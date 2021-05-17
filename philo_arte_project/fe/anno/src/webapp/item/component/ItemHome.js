import React from "react"
import dataTestimonials from "../../data/Testimonials/testimonials-data.json";
import dataClients from "../../data/Clients/clients-data.json";
import dataNavbar from "../../data/Navbar/parallax-digital-navbar-data.json";
import dataPortfolio from "../../data/Portfolio/main-portfolio-data.json";

import Loader from "../../common/Loader/Loader";
import FooterOne from "../../common/Footer/FooterOne";
import HeaderSocial from "../../common/Header/HeaderSocial";
import HomeDigitalSlider from "../component/showing/HomeDigitalSlider"
import PortfolioBoxedSpaceThree from "../../common/Portfolio/PortfolioBoxedSpaceThree";
import TestimonialsThree from "../../common/Testimonials/TestimonialsThree";
import ClientsGrid from "../../common/Carousel/ClientsGrid";

const ItemHome = () =>{
    return(
        <>


    <HeaderSocial data={dataNavbar} />
    <HomeDigitalSlider />
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
    ]}/>
    <TestimonialsThree data={dataTestimonials} title="Our Clients Say">
      {/* <ClientsGrid data={dataClients} classes="mt-100" /> */}
    </TestimonialsThree>

    <FooterOne/>
    
    
    </>

    )
}
export default ItemHome