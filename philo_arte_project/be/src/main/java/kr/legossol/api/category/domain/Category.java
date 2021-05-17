package kr.legossol.api.category.domain;

import javax.persistence.*;

import kr.legossol.api.resume.domain.Resume;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "category_name")
    private String categoryName;
}