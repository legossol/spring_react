package kr.legossol.api.common.Crawling;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// import kr.legossol.api.common.Crawling.Crawlers.Funding;
import kr.legossol.api.common.Crawling.Crawlers.cralSomething;
import kr.legossol.api.common.domain.Crawler;

public class CrawlMain {
    // public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
    // public static final String WEB_DRIVER_PATH = "/Users/haesoljang/filestore/chromedriver.exe"; //드라이버 경로
    public static void main(String[] args) throws IOException {
//        String url = "http://www.yes24.com/24/Category/Display/001001003022";
//        String cssQuery = ".clearfix";
        String filePath = "/Users/haesoljang/filestore/dummy.csv";
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/haesoljang/filestore/chromedriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        String url = "https://www.wadiz.kr/web/campaign/detail/qa/110574";
        driver.get(url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        Crawler crawler = new Crawler();
        // Service service = new Service();
        List<cralSomething> list = new ArrayList<>();
        List<WebElement> el3 = driver.findElements(By.cssSelector(".CommentTextContent_contentBox__5dJa1"));
        try{
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8"));
            for (int i = 0; i < el3.size(); i++) {
                cralSomething thing = new cralSomething();
                thing.setContents(el3.get(i).getText());
                thing.setAddress(el3.get(i).getAttribute("href"));
                thing.setCategory(crawler.getCategory());
                System.out.println(thing.getContents());
                list.add(thing);
            }
            if(list.isEmpty()){
                System.out.println("크롤링 된 값이 없습니다. !");
            }else{
                for(cralSomething f : list){
                    fw.write(f.getContents()+",");
                    fw.newLine();
                }
            }
            fw.flush();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Crawlers {
    private String url;
    private String cssQuery;
    private String category;
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCssQuery() {
        return cssQuery;
    }
    public void setCssQuery(String cssQuery) {
        this.cssQuery = cssQuery;
    }
    public static class cralSomething{
        private String category;
        private String contents;
        private String address;

        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public String getContents() {
            return contents;
        }
        public void setContents(String contents) {
            this.contents = contents;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
    }

    
}