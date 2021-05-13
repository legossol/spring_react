package kr.legossol.api.review.domain;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.common.domain.Crawler;
import kr.legossol.api.item.domain.Item;
import kr.legossol.api.supporter.domain.Supporter;

@Entity
@ToString
@Data
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;
    @Column(name = "parent_item") 
    private String parentItem;
    
    // private int depth;
    // private int bundleId;
    // private int bundleOrder;
    // private 
    
    @Column(name = "parent_review")
    private String parentReview;

    @Column(name = "writer")    
    private String writer;
    @Column(name = "content")
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    private Date regDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "edit_date")
    private Date editDate;

    @Column(name = "like_Cnt")
    private int likeCnt;
    @Column(name = "dislike_Cnt")
    private int dislikeCnt;
    @Column(name = "like_check")
    private int likeCheck;
    //foreign key 유저 번호, 보드 번호

	public void setTitle(String text) {
	}
	public void setAddress(String attr) {
	}
	public void setCategory(String category) {
	}
    
    
    
}
