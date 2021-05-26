package kr.legossol.api.resume.domain;

import javax.persistence.*;


import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.category.domain.Category;


@Entity
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long resumeId;
    @Column(name = "title")
    private String title;
    @Column(name = "self_introduce")
    private String selfIntroduce;
    @Column(name = "detail")
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public void changeTitle(String title) {
        this.title = title;
    }

}