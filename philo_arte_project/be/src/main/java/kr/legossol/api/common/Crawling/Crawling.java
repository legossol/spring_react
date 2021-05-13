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
import org.openqa.selenium.WebElement;

public class Crawling {
//     public static void main(String[] args) throws IOException {
//         String url = "https://news.naver.com/";
//         String cssQuery = "div.mtype_list_wide>ul>li>a>strong";
//         String filePath = "/Users/haesoljang/filestore";
//         Crawler crawler = new Crawler();
//         Service service = new Service();
//         crawler.setUrl(url);
//         crawler.setCssQuery(cssQuery);
//         Document document = service.connectUrl(crawler.getUrl());
//         Elements elements = document.select(crawler.getCssQuery());
//         List<Funding> list = new ArrayList<>();
//         try{
//             BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath,true),"euc-kr"));
//             for (int i = 0; i < elements.size(); i++) {
//                 Funding funding = new Funding();
//                 funding.setTitle(elements.get(i).text());
//                 funding.setAddress(elements.get(i).attr("href"));
//                 funding.setCategory(crawler.getCategory());
//                 System.out.println(funding.toString());
//                 list.add(funding);
//             }
//             if(list.isEmpty()){
//                 System.out.println("크롤링 된 값이 없습니다. !");
//             }else{
//                 for(Funding f : list){
//                     fw.write(f.toString()+",");
//                     fw.newLine();
//                 }
//             }
//             fw.flush();
//             fw.close();
//         }catch (Exception e){
//             e.printStackTrace();
//         }
//     }
//  }
//  class Crawler {
//     private String url;
//     private String cssQuery;
//     private String category;
//     public String getCategory() {
//         return category;
//     }
//     public void setCategory(String category) {
//         this.category = category;
//     }
//     public String getUrl() {
//         return url;
//     }
//     public void setUrl(String url) {
//         this.url = url;
//     }
//     public String getCssQuery() {
//         return cssQuery;
//     }
//     public void setCssQuery(String cssQuery) {
//         this.cssQuery = cssQuery;
//     }
//     public static class Funding{
//         private long tumblebuckId;
//         private String category;
//         private String title;
//         private String address;
//         public long getTumblebuckId() {
//             return tumblebuckId;
//         }
//         public void setTumblebuckId(Long tumblebuckId) {
//             this.tumblebuckId = tumblebuckId;
//         }
//         public String getCategory() {
//             return category;
//         }
//         public void setCategory(String category) {
//             this.category = category;
//         }
//         public String getTitle() {
//             return title;
//         }
//         public void setTitle(String title) {
//             this.title = title;
//         }
//         public String getAddress() {
//             return address;
//         }
//         public void setAddress(String address) {
//             this.address = address;
//         }
//     }
//  }
//  class Funding {
 
//     private long tumblebuckId;
//     private String category;
//     private String title;
//     private String address;
 
//     public long getTumblebuckId() {
//         return tumblebuckId;
//     }
 
//     public void setTumblebuckId(long tumblebuckId) {
//         this.tumblebuckId = tumblebuckId;
//     }
 
//     public String getCategory() {
//         return category;
//     }
 
//     public void setCategory(String category) {
//         this.category = category;
//     }
 
//     public String getTitle() {
//         return title;
//     }
 
//     public void setTitle(String title) {
//         this.title = title;
//     }
 
//     public String getAddress() {
//         return address;
//     }
 
//     public void setAddress(String address) {
//         this.address = address;
//     }
//     public String toString(){
//         return category+","+title+","+address;
//     }
//  }
//  class Service{
//      List<Funding> saveAll(Crawler crawler) throws IOException {
//         Document document = connectUrl(crawler.getUrl());
//         Elements elements = document.select(crawler.getCssQuery());
//         List<Funding> list = new ArrayList<>();
//         for (int i = 0; i < elements.size(); i++) {
//             Funding funding = new Funding();
//             funding.setTitle(elements.get(i).text());
//             funding.setAddress(elements.get(i).attr("href"));
//             funding.setCategory(crawler.getCategory());
//             list.add(funding);
//         }
//         return list;
//     }
//     Document connectUrl(String url) throws IOException {
//         return Jsoup.connect(url) // 클래스 안에 이너클래스
//                 .method(Connection.Method.GET)
//                 .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) " +
//                         "Gecko/20100101 Firefox/10.0 " +
//                         "AppleWebKit/537.36 (KHTML, like Gecko) " +
//                         "Chrome/51.0.2704.106 Safari/537.36")
//                 .execute().parse();
//     }
//      List<?> scrapFunding(Crawler crawler) throws IOException {
//         Document fundingdocument = connectUrl(crawler.getUrl()); 
//         Elements fundingelements = fundingdocument.select(crawler.getCssQuery());
       
//         for (int i = 0; i < fundingelements.size(); i++) {
//             Funding funding = new Funding();
//             funding.setTitle(fundingelements.get(i).text());
//             funding.setAddress(fundingelements.get(i).attr("href"));
//             funding.setCategory(crawler.getCategory());
//         }
 
//         return null;
//     }
 
 }
 
 