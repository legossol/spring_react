package com.example.demo.its.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "sale_items")
@NoArgsConstructor
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_no")
    private long itemNo;

    //////////////////////////////////////////
    @Column(name = "hash_tag")
    private String hashTag;
    @Column(name = "item_picture")
    private String itemPicture;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "reg_date")
    private Date regDate;
    /////////////////////////////////////////
    @Column(name = "price")
    private String price;
    //////////////////////////////////////////
    @Column(name = "writer")
    private String writer;
    //////////////////////////////////////////
    @Column(name = "sold_out")
    private Boolean soldOut;

    @Builder
    public SaleItem(Long itemNo, String itemPicture, String hashTag, String title, String writer, String content,
            String price, Boolean soldOut, Date regDate) {
        this.itemNo = itemNo;
        this.itemPicture = itemPicture;
        this.hashTag = hashTag;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.price = price;
        this.soldOut = soldOut;
        this.regDate = regDate;
    }

}
