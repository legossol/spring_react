package kr.legossol.api.funding.domain;


import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.common.domain.BaseEntity;
@Entity
@Getter
@Setter
@RequiredArgsConstructor
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
}
