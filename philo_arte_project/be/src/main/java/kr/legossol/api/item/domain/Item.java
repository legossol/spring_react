package kr.legossol.api.item.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.category.domain.Category;
import kr.legossol.api.file.domain.File;
import kr.legossol.api.supporter.domain.Supporter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "title")
    private String title;
    @Column(name = "writer")     //creatorId
    private String writer;      
    @Column(name = "content")
    private String content;
    @Column(name = "goal_price")
    private String goalPrice;
    @Column(name = "view_cnt")
    private int viewCnt;

    @Temporal(TemporalType.TIMESTAMP)   //등록일
    @Column(name = "reg_date")
    private Date regDate;
    @Temporal(TemporalType.TIMESTAMP)   //수정일
    @Column(name = "edit_date")
    private Date editDate;

    @Column(name = "like_Cnt")  //좋아요숫자
    private int likeCnt;
    @Column(name = "dislike_Cnt")
    private int dislikeCnt;
    @Column(name = "like_check")
    private int likeCheck;

    // @ManyToOne
    // private Artist artist;  //글작성자, 좋아요 연결

    // @ManyToOne
    // private Supporter supporter; //좋아요 누른 사람 연결


    // @OneToMany
    // private Collection<File> fileList;

    // @ManyToOne
    // @JoinColumn(name = "category_id")
    // private Category category;
}
