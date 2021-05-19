package kr.legossol.api.funding.domain;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.common.domain.BaseEntity;
import kr.legossol.api.common.util.ModelMapperUtils;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fundings")
public class Funding extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "funding_id")
    private Long fundingId;
    @Column(name = "title")
    private String title;     
    @Column(name = "content")
    private String content;
    @Column(name = "goal_price")
    private Number goalPrice;
    @Column(name = "view_cnt")
    private int viewCnt;
    @Column(name = "hashtag")
    private String hashtag;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    
    @Builder
    public Funding(String title, String content, Number goalPrice, String hashtag) {
        this.title = title;
        this.content = content;
        this.goalPrice = goalPrice;
        this.hashtag = hashtag;
    }
    
    public static Funding of(FundingDto fundingDto){
        Funding funding = ModelMapperUtils.getModelMapper().map(fundingDto, Funding.class);
        return funding;
    }
    
}
