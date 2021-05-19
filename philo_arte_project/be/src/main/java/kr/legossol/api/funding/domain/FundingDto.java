package kr.legossol.api.funding.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FundingDto {
    private Long fundingId;
    private String title;     
    private String content;
    private Number goalPrice;
    private int viewCnt;
    private String hashtag;

    // public FundingDto(Funding funding) {
    //     this.title = funding.getTitle();
    //     this.content = funding.getContent();
    //     this.goalPrice = funding.getGoalPrice();
    //     this.viewCnt = funding.getViewCnt();
    //     this.hashtag = funding.getHashtag();
    // }
   

    
}
