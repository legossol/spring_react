package shop.jinwookoh.api.work.dmain;

import javax.persistence.*;

import shop.jinwookoh.api.artist.domain.Artist;
import shop.jinwookoh.api.category.domain.Category;

import java.util.Date;
@Entity
@Table(name = "works")
public class Work {
    @Id
    @GeneratedValue
    @Column(name = "work_id")
    private long workId;
    @Column
    private String title;
    @Column
    private String description;
    @Column(name = "main_img")
    private String mainImg;
    @Column(name = "reg_date")
    private Date regDate;
    @Column(name = "edit_date")
    private Date editDate;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    Artist artist;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
