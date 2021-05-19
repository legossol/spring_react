package kr.legossol.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.h2.store.fs.FilePath;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import kr.legossol.api.common.domain.Crawler;
import kr.legossol.api.common.util.ModelMapperUtils;
import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.repository.FundingRepository;
import kr.legossol.api.review.domain.Review;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ApiApplicationTests {
    @Autowired
    private FundingRepository repo;

    @Test
    public void testSave(){
        FundingDto dto = new FundingDto();
        dto.setTitle("새로운 저장");
        dto.setContent("새로운 내용저장");
        dto.setGoalPrice(3000);
        dto.setHashtag("묵화");

        Funding fund = ModelMapperUtils.getModelMapper().map(dto, Funding.class);
        assertEquals(dto.getTitle(),fund.getTitle() );
        assertEquals(dto.getContent(),fund.getContent() );
        assertEquals(dto.getGoalPrice(),fund.getGoalPrice() );
        assertEquals(dto.getHashtag(),fund.getHashtag() );
    }
	// @Test
	// void contextLoads() {
		
    // }
    // @Test
    // @Commit
    // public void testFindAllpage() {
    //     Pageable pageable = PageRequest.of(0, 10);
    //     repo.getAllarticle(pageable).get().forEach(funding->{
    //         log.info(funding);
    //         log.info(funding.getTitle);
    //         log.info("-----------------");
    //     })
    // }
    // @Test
    // public void testCreate(){
    //     FundingDto fundingDto = new FundingDto();
    //     fundingDto.setTitle("새로운 저장");
    //     fundingDto.setContent("새로운 내용저장");
    //     fundingDto.setGoalPrice(3000);
    //     fundingDto.setHashtag("묵화");

    //     Funding funding = ModelMapperUtils.getModelMapper().map(fundingDto, Funding.class);
    //     funding.getTitle();
    //     funding.getContent();
    //     funding.getGoalPrice();
    //     funding.getHashtag();

    //     repo.save(funding);

    // }
    // @Test//파인드올
    // public void testFindAll() {
    //    List<Funding> result = repo.getAllFundings();
    //    for(Funding funding: result){
    //        System.out.println(funding+" : " + funding.getTitle());
    //        log.info(result);
    //    }
        
    // }
    // @Test //파인드바이앙디
    // public void testFindbyid(){
    //     Optional<Funding> result = repo.findByFundingId(8);
       
    //     System.out.println(result);
    //     log.info(result);
    // }
    // @Test
    // @Transactional
    // public void testUpdate(){
    //     Optional<Funding> result = repo.findByFundingId(8);
        
    //     FundingDto fundingDto = new FundingDto();
    //     fundingDto.setTitle("바뀐제목");
    //     fundingDto.setContent("내용은  이것으로 바뀌었지");
    //     fundingDto.setGoalPrice(1923929);
    //     fundingDto.setHashtag("hashtag");
        
        // Funding funding = ModelMapper.map(fundingDto, Funding.class);
        // assertEquals(fundingDto.getTitle(), funding.getTitle());
        // assertEquals(fundingDto.getContent(), funding.getContent());
        // assertEquals(fundingDto.getGoalPrice(), funding.getGoalPrice());
        // assertEquals(fundingDto.getHashtag(), funding.getHashtag());


        
    }

	// @Test
    // public void testURL() throws Exception{

    //     String urlStr = "https://www.wadiz.kr/web/reward/api/comments/campaigns/109463?page=0&size=15&commentGroupType=CAMPAIGN";

    //     URL url = new URL(urlStr);

    //     byte[] buffer = new byte[1024*8];

    //     ByteArrayOutputStream bos = new ByteArrayOutputStream();

    //     InputStream inputStream =url.openStream();

    //     while(true){

    //         int count = inputStream.read(buffer);

    //         if(count == -1){
    //             break;
    //         }
    //         bos.write(buffer,0,count);
    //     }

    //     System.out.println(bos.toString("UTF-8"));

    // }

    // @Test
    // public void testSelenium()throws Exception  {
	// 	String filePath = "C:/Users/haesoljang/filestore";


    //     WebDriver driver = new ChromeDriver();
    //     System.setProperty("webdriver.chrome.driver", "/Users/haesoljang/filestore/chromedriver.exe");

    //     //Convenient
    //     driver.get("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=018&aid=0004928141");

	// 	Thread.sleep(1000);
		
	// 	Crawler crawler = new Crawler();
	// 	List<Review> list = new ArrayList<>();
	// 	List<WebElement> replyList = driver.findElements(By.className("u_cbox_text_wrap"));
	// 	try{
    //         BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"euc-kr"));
    //         for (int i = 0; i < replyList.size(); i++) {
    //             Review review = new Review();
    //             // review.setTitle(replyList.get(i).getText());
    //             // review.setAddress(replyList.get(i).getAttribute("href"));
    //             // review.setCategory(crawler.getCategory());
    //             System.out.println(review.toString());
    //             list.add(review);
    //         }
    //         if(list.isEmpty()){
    //             System.out.println("크롤링 된 값이 없습니다. !");
    //         }else{
    //             for(Review f : list){
    //                 fw.write(f.toString()+",");
    //                 fw.newLine();
    //             }
    //         }
    //         fw.flush();
    //         fw.close();
    //     }catch (Exception e){
    //         e.printStackTrace();
    //     }


    //     for (WebElement webElement : replyList) {

    //         System.out.println(webElement.getText());
    //         System.out.println("-----------------------------------");
	// 	}
		
	// }



	
// 	@Test
//  	public void testExportAllRecords() throws InterruptedException {
// 		 WebDriver driver;
// 	driver.get("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=018&aid=0004928141");
// 	int noOfEntries = getNumberOfEntries();
// 	System.out.println("Total number of entries are :- "+noOfEntries);
	
// 	WebElement elementCSV = driver.findElement(By.xpath(".//*[@id='ToolTables_example_1']/span[contains(text(),'CSV')]"));
// 	elementCSV.click();
	
// 	File file = getLatestFilefromDir("/Users/haesoljang/filestore");
// 	String csvFileName = file.getName();
// 	System.out.println("CSV File Downloaded is :- "+csvFileName);
	
// 	System.out.println("Verifying number of entries with number of entries in csv");
// 	Assert.assertEquals(noOfEntries, getRecordsCountInCSV(downloadPath,csvFileName));
//  }
	
