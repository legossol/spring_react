import React from 'react'
import {Link} from 'react-router-dom'

const ItemList = () =>{
   
    return (
        <>

        <h1>아 이 템 리 스 트</h1>
        <table>
            <tr>
                <th>itemId</th>
                <th>title</th>
                <th>writer</th>
                <th>content</th>
                <th>goalPrice</th>
                <th>viewCnt</th>
            </tr>
            <tr>
                <td>0</td>
                <td>Korea</td>
                <td>diablo</td>
                <td>skdnkfwnipef</td>
                <td>100,000</td>
                <td>30</td>
                <th><button>수정</button></th>
                <th><button>삭제</button></th>
            </tr>
            <tr>
                <td>1</td>
                <td>England</td>
                <td>Human</td>
                <td>skdnkfwnipefsdfasdvbwvrgwevesd</td>
                <td>300000</td>
                <td>1</td>
                <th><button>수정</button></th>
                <th><button>삭제</button></th>
            </tr>
        </table>
        <tbody>
            <Link to={"/category/item/register"}>
                <button>펀딩 등록하기</button>
            </Link>
        </tbody>

  <Loader>
    <HeaderSocial data={dataNavbar} />
    <HeroParallax />
    <WhatWeOfferNine>
      <TabsOne data={dataTabs} />
    </WhatWeOfferNine>
    <PresentationTwo
      title="Superb Website Template <br /> for Startups & Small Businesses."
      text="We Are provide web design services to startups and existing business in<br> New York and around the US helping them make an impact online."
      textBtn="Read more"
      pathBtn={process.env.PUBLIC_URL}
    />
    <SkillBarRingSection data={dataRings} />
    <PortfolioBoxedSpaceFour
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
  </p>'
    >
      <CounterRowOne data={dataCounter} classes="mt-50" />
    </AboutFive>
    <ParallaxTwo
      title="Let Your Email Address Speak for You"
      tagline="Join us on social media"
      textBtn="Read more"
      pathBtn={process.env.PUBLIC_URL}
      image={imgParallax}
    />
    <TestimonialsThree data={dataTestimonials} title="Our Clients Say">
      <ClientsGrid data={dataClients} classes="mt-100" />
    </TestimonialsThree>
    <BlogSection title="Our Latest Blogs" data={dataBlog} />
    <ContactSeven title="Request a Quote Now" />
    <MapSection />
    <FooterThree />
  </Loader>
);
        
        </>
    )
}
export default ItemList