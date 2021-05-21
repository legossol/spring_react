package kr.legossol.api.funding.domain;


import java.util.ArrayList;

import javax.persistence.*;

import com.amazonaws.services.codecommit.model.transform.FileContentAndSourceFileSpecifiedExceptionUnmarshaller;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.category.domain.Category;
import kr.legossol.api.common.domain.BaseEntity;
import kr.legossol.api.common.util.ModelMapperUtils;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private long goalPrice;
    @Column(name = "view_cnt")
    private long viewCnt;
    @Column(name = "hashtag")
    private String hashtag;
    

    public Funding(FundingDto dto) {
        this.title = dto.getTitle();
    }

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    
  
    public static Funding of(FundingDto fundingDto){
        return ModelMapperUtils.getModelMapper().map(fundingDto, Funding.class);
    }
    // Dto -> Entity(Page)
    public static Page<Funding> of(Page<FundingDto> sourcePage){
        return sourcePage.map(Funding::of);
    }
    public void saveRequest(FundingDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.goalPrice = requestDto.getGoalPrice();
        this.hashtag = requestDto.getHashtag();
    }
}
