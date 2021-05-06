package com.example.demo.news.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long newsId;

    @Column(length = 20, nullable = true)
    private String category;

    @Column()
    private String title;

    @Column()
    private String address;

    @Builder
    public News(long newsId, String category, String title, String address) {
        this.newsId = newsId;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}