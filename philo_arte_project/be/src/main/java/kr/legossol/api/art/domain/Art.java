package kr.legossol.api.art.domain;

import javax.persistence.*;

import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.category.domain.Category;
import lombok.Data;

@Entity
@Table(name = "arts")
@Data
public class Art {
    @Id
    @GeneratedValue
    @Column(name = "art_id")
    private Long workId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}