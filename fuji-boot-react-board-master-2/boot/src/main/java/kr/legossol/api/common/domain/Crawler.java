package kr.legossol.api.common.domain;

import org.springframework.stereotype.Component;


public class Crawler {
    private String url;
    private String cssQuery;
    private String category;
    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCssQuery() {
        return cssQuery;
    }

    public void setCssQuery(String cssQuery) {
        this.cssQuery = cssQuery;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public static class News{
        private Long newsId;
        private String category;            
        private String title;            
        private String address;
        public Long getNewsId() {return newsId;}
        public String getAddress() {return address;}
        public void setAddress(String address) {this.address = address;}
        public String getTitle() {return title;}
        public void setTitle(String title) {this.title = title;}
        public String getCategory() {return category;}
        public void setCategory(String category) {this.category = category;}
        public void setNewsId(Long newsId) {this.newsId = newsId;}
    }

    
}
