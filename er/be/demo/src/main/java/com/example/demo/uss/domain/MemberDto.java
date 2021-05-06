package com.example.demo.uss.domain;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

@Component
@Data
public class MemberDto {

    @ApiModelProperty(position = 0)
    private String username;
    @ApiModelProperty(position = 1)
    private String email;
    @ApiModelProperty(position = 2)
    private String password;
    @ApiModelProperty(position = 3)
    private String name;
    @ApiModelProperty(position = 4)
    private String token;
    @ApiModelProperty(position = 5)
    private List<Role> roles;

    // private Boolean isActive;
    // private String address;
    // private String birthday;
    // private String phoneNo;
    // private String gender;
    // private Date createAt;
    // private Date updateAt;

}
