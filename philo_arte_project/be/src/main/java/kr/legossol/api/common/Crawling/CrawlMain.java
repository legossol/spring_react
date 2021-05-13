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

import kr.legossol.api.common.Crawling.Crawlers.Funding;
import kr.legossol.api.common.domain.Crawler;

public class CrawlMain {
    // public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
    // public static final String WEB_DRIVER_PATH = "/Users/haesoljang/filestore/chromedriver.exe"; //드라이버 경로
    public static void main(String[] args) throws IOException {
//        String url = "http://www.yes24.com/24/Category/Display/001001003022";
//        String cssQuery = ".clearfix";
        String filePath = "/Users/haesoljang/filestore/cssample.csv";
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/haesoljang/filestore/chromedriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        String url = "https://www.wadiz.kr/web/campaign/detail/qa/107616";
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
        Service service = new Service();
        List<Funding> list = new ArrayList<>();
        List<WebElement> el3 = driver.findElements(By.cssSelector(".CommentTextContent_container__3dH_P"));
        try{
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"euc-kr"));
            for (int i = 0; i < el3.size(); i++) {
                Funding funding = new Funding();
                funding.setTitle(el3.get(i).getText());
                funding.setAddress(el3.get(i).getAttribute("href"));
                funding.setCategory(crawler.getCategory());
                System.out.println(funding.getTitle());
                list.add(funding);
            }
            if(list.isEmpty()){
                System.out.println("크롤링 된 값이 없습니다. !");
            }else{
                for(Funding f : list){
                    fw.write(f.getTitle()+",");
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
    public static class Funding{
        private long tumblebuckId;
        private String category;
        private String title;
        private String address;
        public long getTumblebuckId() {
            return tumblebuckId;
        }
        public void setTumblebuckId(Long tumblebuckId) {
            this.tumblebuckId = tumblebuckId;
        }
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
    }
}
class Fundings {
    private long tumblebuckId;
    private String category;
    private String title;
    private String address;
    public long getTumblebuckId() {
        return tumblebuckId;
    }
    public void setTumblebuckId(long tumblebuckId) {
        this.tumblebuckId = tumblebuckId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
class Service{
    List<Funding> saveAll(Crawler crawler) throws IOException {
        Document document = connectUrl(crawler.getUrl());
        Elements elements = document.select(crawler.getCssQuery());
        List<Funding> list = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            Funding funding = new Funding();
            funding.setTitle(elements.get(i).text());
            funding.setAddress(elements.get(i).attr("href"));
            funding.setCategory(crawler.getCategory());
            list.add(funding);
        }
        return list;
    }
    Document connectUrl(String url) throws IOException {
        return Jsoup.connect(url) // 클래스 안에 이너클래스
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) " +
                        "Gecko/20100101 Firefox/10.0 " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/51.0.2704.106 Safari/537.36")
                .execute().parse();
    }
    List<?> scrapFunding(Crawler crawler) throws IOException {
        Document fundingdocument = connectUrl(crawler.getUrl()); // jsoup 불변객체, "https://news.daum.net/society"
        //List<>
        Elements fundingelements = fundingdocument.select(crawler.getCssQuery());
        //"div.sect-movie-chart>ol>li>div.box-image>strong"
        for (int i = 0; i < fundingelements.size(); i++) {
            Funding funding = new Funding();
            funding.setTitle(fundingelements.get(i).text());
            funding.setAddress(fundingelements.get(i).attr("href"));
            funding.setCategory(crawler.getCategory());
        }

        return null;
    }
}