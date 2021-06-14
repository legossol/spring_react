package kr.legossol.api.common.Crawling;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// import kr.legossol.api.common.Crawling.Crawlers.Funding;
import kr.legossol.api.common.Crawling.Crawlers.cralSomething;
import kr.legossol.api.common.domain.Crawler;

public class CrawlMain {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/haesoljang/filestore/dumdum.csv";
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/haesoljang/filestore/chromedriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        String url = "https://www.ycrowdy.com/r/deukki";
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
        List<cralSomething> list = new ArrayList<>();
        List<WebElement> t = driver.findElements(By.cssSelector("#reward-detail > div > div:nth-child(1) > div > div > div.col-sm-8 > div"));
        List<WebElement> c = driver.findElements(By.cssSelector("#reward-detail > div > div.mt40.xs-mt20.mb100 > div > div > div.mce-content-body > div > p:nth-child(4)"));
        List<WebElement> g = driver.findElements(By.cssSelector("#reward-detail > div > div:nth-child(1) > div > div > div:nth-child(2) > div.col-sm-4.mb30.xs-mt25.xs-mb20.pl45.pr15.xs-pl15.xs-pr15 > div.reward-info-box > div.reward-info-amount"));
        List<WebElement> v = driver.findElements(By.cssSelector("#reward-detail > div > div:nth-child(1) > div > div > div:nth-child(2) > div.col-sm-4.mb30.xs-mt25.xs-mb20.pl45.pr15.xs-pl15.xs-pr15 > div.reward-info-box > div:nth-child(5) > span.reward-info-now"));
        List<WebElement> h = driver.findElements(By.cssSelector("#reward-detail > div > div:nth-child(1) > div > div > div:nth-child(2) > div.col-sm-4.mb30.xs-mt25.xs-mb20.pl45.pr15.xs-pl15.xs-pr15 > div.reward-info-box > div.reward-info-name"));
        try{
            DataOutputStream fw = new DataOutputStream(new FileOutputStream(filePath,true));
            for (int i = 0; i < t.size(); i++) {
                cralSomething thing = new cralSomething();
                thing.setTitle(t.get(i).getText());
                thing.setContent(c.get(i).getText());
                thing.setGoalPrice(g.get(i).getText());
                thing.setViewCnt(v.get(i).getText());
                thing.setHashtag(h.get(i).getText());

                System.out.println(thing.getTitle());
                System.out.println(thing.getContent());
                System.out.println(thing.getGoalPrice());
                System.out.println(thing.getHashtag());
                System.out.println(thing.getViewCnt());
                list.add(thing);
            }
            if (list.isEmpty()) {
                System.out.println("크롤링 된 값이 없습니다. !");
            } else {
                for (cralSomething a : list) {
                    fw.writeUTF(a.toString() + "\n");
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
        
        
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
        public String getHashtag() {
            return hashtag;
        }
        public void setHashtag(String hashtag) {
            this.hashtag = hashtag;
        }
        private String title;     
        @Override
        public String toString() {
            return "\n [content=" + content + ", goalPrice=" + goalPrice + ", hashtag=" + hashtag
                    + ", title=" + title + ", viewCnt=" + viewCnt + "] \n";
        }
        private String content;
        private String goalPrice;
        public String getGoalPrice() {
            return goalPrice;
        }
        public String getViewCnt() {
            return viewCnt;
        }
        public void setGoalPrice(String goalPrice) {
            this.goalPrice = goalPrice;
        }
        public void setViewCnt(String viewCnt) {
            this.viewCnt = viewCnt;
        }
        private String viewCnt;
        private String hashtag;
       
}
}