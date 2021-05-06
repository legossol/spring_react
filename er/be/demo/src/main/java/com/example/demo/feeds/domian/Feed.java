package com.example.demo.feeds.domian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feeds")
public class Feed {
    @Id
    @GeneratedValue
    @Column(name = "feed_no")
    private long feedNo;
    @Column(name = "title")
    private String title;
    @Column(name = "writer")
    private String writer;
    @Column(name = "content")
    private String content;
    @Column(name = "add_location")
    private String addLocation;
    @Column(name = "hash_tag")
    private String hashTag;
    @Column(name = "reg_date")
    private String regDate;
}