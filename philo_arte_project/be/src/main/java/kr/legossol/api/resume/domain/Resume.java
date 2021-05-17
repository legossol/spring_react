package kr.legossol.api.resume.domain;

import java.util.Date;

import javax.persistence.*;

import kr.legossol.api.artist.domain.Artist;


@Entity
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private long resumeId;
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;
    @Column(name = "coworker")
    private String coworker;
    @Column(name = "main_pic")
    private String mainPic;
    @Column(name = "main_pic_title")
    private String mainPicTitle;
    @Column(name = "main_pic_date")
    private Date mainPicDate;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    // public static Resume of(ResumeDto resumeDto) {
    //     Resume resume = ModelMapperUtils.getModelMapper().map(resumeDto, Resume.class);
    //     return resume;
    // }
}