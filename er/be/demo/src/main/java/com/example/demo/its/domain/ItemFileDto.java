package com.example.demo.its.domain;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@Getter
public class ItemFileDto {
    private long fileNo;
    private String ofname;
    private String sfname;
    private long fsize;

}
