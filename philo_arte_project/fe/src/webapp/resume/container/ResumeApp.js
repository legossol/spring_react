import React from "react";
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import dataServices from "webapp/common/data/Services/services-studio-data.json";
import dataSkills from "webapp/common/data/Skills/skills-data.json";
import dataCounters from "webapp/common/data/Counters/counters-data.json";
import dataTeam from "webapp/common/data/Team/team-data.json";

import HeaderTwo from "webapp/common/Header/HeaderTwo";
import FooterOne from "webapp/common/Footer/FooterOne";
import WhatWeOfferSix from "webapp/common/WhatWeOffer/WhatWeOfferSix";
import TeamOne from "webapp/common/Team/TeamOne";
import CounterRowOne from "webapp/resume/component/Presentation/CounterRowOne"
import PresentationTwo from "webapp/resume/component/Presentation/PresentationTwo";
import AboutFive from "webapp/resume/component/Presentation/AboutFive"

import {ResumeList} from "webapp/resume/index"

import { useSelector } from "react-redux";




const ResumeApp = () => {

  const resumes = useSelector(state => state.resumes)
  
  return(<>
    <HeaderTwo data={dataNavbar} />
    <PresentationTwo
      title="언제, 어디서나 <br/> 당신의 포트폴리오를 관리해보세요."
      text="포트폴리오를 등록해 놓으면 자동으로 당신의 작품이 포트폴리오에 등록이 됩니다."
      textBtn="REGISTER"
      pathBtn={process.env.PUBLIC_URL}
    />
    <WhatWeOfferSix
      tagline="Philo-Portfolio"
      title='Philo-arte만의 <br/>차별화된 포트폴리오<br/> <span class="text-bottom-line-sm"> 관리 서비스</span>'
      pathBtn={"/"}
      data={dataServices}
    />
    <ResumeList
        data = {resumes}
        tagline="Show Your Works"
        title= "Your Portfolio"
        filter={true}
        categories={[
          "Branding",
          "Creative Design",
          "Web Design",
          "Stationery",
          "Photography",
        ]}
      />
        <AboutFive
      data={dataSkills}
      title="Agency Overview"
      text='<p class="mt-30">
    Every site we create is designed and optimised to look and function
    just as well on mobile phones and tablets as it does on a desktop,
    creating a seamless experience across any device.
  </p>
  <p>
    We use the latest development standards and web technologies to keep
    things cutting edge, ensuring your new website is built on a stable
    and future-proof foundation.
  </p>'>
    <CounterRowOne data={dataCounters} classes="mt-50" />
    </AboutFive>
    <TeamOne
      tagline="MEET OUR INFLUENCER"
      title='다양한 아트 인플루언서들을 <span class="text-bottom-line-sm">만나보세요</span>'
      data={dataTeam}
    >
      Web teams are made up of a diverse group of people who all contribute
      their skills in multiple avenues. Each person has a different role that
      combines with the others to work toward a common goal.
    </TeamOne>
    <FooterOne/>
</>)
};

export default ResumeApp;
