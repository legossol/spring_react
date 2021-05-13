package kr.legossol.api.common.Crawling;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
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
    // public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
    // public static final String WEB_DRIVER_PATH = "/Users/haesoljang/filestore/chromedriver.exe"; //드라이버 경로
    public static void main(String[] args) throws IOException {
//        String url = "http://www.yes24.com/24/Category/Display/001001003022";
//        String cssQuery = ".clearfix";
        String filePath = "/Users/haesoljang/filestore/item2.csv";
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/haesoljang/filestore/chromedriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        // String url = "https://www.wadiz.kr/web/campaign/detail/110574";
        String url = "https://www.wadiz.kr/web/campaign/detail/qa/108794";
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
        // List<WebElement> el3 = driver.findElements(By.cssSelector(".page-container"));
        // List<WebElement> t = driver.findElements(By.cssSelector(".campaign-summary"));
        List<WebElement> c = driver.findElements(By.cssSelector(".CommentTextContent_contentBox__5dJa1"));
        // List<WebElement> m = driver.findElements(By.cssSelector(".total-amount"));
        // List<WebElement> w = driver.findElements(By.cssSelector(".CommentUserInfo_name__2GoPA a"));
        // List<WebElement> v = driver.findElements(By.cssSelector(".total-supporter"));
        try{
            // BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8"));
            DataOutputStream fw = new DataOutputStream(new FileOutputStream(filePath, true));
            for (int i = 0; i < c.size(); i++) {
                cralSomething thing = new cralSomething();
                // thing.setTitle(t.get(i).getText());
                // thing.setGoalPrice(m.get(i).getText());
                thing.setContent(c.get(i).getText());
                // thing.setWriter(w.get(i).getText());
                // thing.setViewCnt(v.get(i).getText());

                // System.out.println(thing.getTitle());
                // System.out.println(thing.getGoalPrice());
                System.out.println(thing.getContent());
                // System.out.println(thing.getWriter());
                // System.out.println(thing.getViewCnt());
                list.add(thing);
            }
            if(list.isEmpty()){
                System.out.println("크롤링 된 값이 없습니다. !");
            }else{
                for(cralSomething f : list){
                    byte[] arr = f.toString().getBytes("UTF-8");
                    fw.write(arr);
                    System.out.println("------------------------------");
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
        
        private Long reviewId;
        private String parentItem;
        private String parentReview;
        private String writer;
        private String content;
        private Date regDate;
        private Date editDate;
        private int likeCnt;
        private int dislikeCnt;
        private int likeCheck;
        
        public String getWriter() {
            return writer;
        }


        public void setWriter(String writer) {
            this.writer = writer;
        }


        public String getContent() {
            return content;
        }


        public void setContent(String content) {
            this.content = content;
        }


        // @Override
        // public String toString() {
        //     return "cralSomething [content=" + content + ", dislikeCnt=" + dislikeCnt + ", editDate=" + editDate
        //             + ", likeCheck=" + likeCheck + ", likeCnt=" + likeCnt + ", parentItem=" + parentItem
        //             + ", parentReview=" + parentReview + ", regDate=" + regDate + ", reviewId=" + reviewId + ", writer="
        //             + writer + "]";
        // }

        @Override
        public String toString(){
            return " \n 댓글 번호 : "+ reviewId + " , 댓글 부모 글 번호: "+parentItem + ", 댓글 부모 번호 : "
            +parentReview+", 댓글쓴이 : "+writer+", 댓글 내용 : "+content+", 등록일 : "+ regDate +", 수정일 : "
            +editDate + ",좋아요 수 :" + likeCnt +", 싫어요 수 :"+dislikeCnt+", 좋아요 체크 :\n";
        }
}
}