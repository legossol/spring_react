package com.example.demo.its.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class SaleItemDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private long itemNo;
    private String itemPicture;
    private String hashTag;
    private String title;
    private String writer;
    private String content;
    private String price;
    private Date regDate;
    private Boolean soldOut;

    @Builder
    public SaleItemDto(Long itemNo, String itemPicture, String hashTag, String title, String writer, String content,
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

    // SaleItemDto saleItemDto =
    // SaleItemDto.builder().itemNo().itemPicture().hashTag().title().writer().content().price()
    // .soldOut().regDate().build();

}
