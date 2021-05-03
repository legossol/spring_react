package kr.legossol.api.user.domain;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
@Data
public class UserDto {
    @ApiModelProperty(position = 0)
    private String username;
    @ApiModelProperty(position = 1)
    private String password;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    private String userName;	
    @ApiModelProperty(position = 4)
    private String age;
    @ApiModelProperty(position = 5)
    private String birthday;	
    @ApiModelProperty(position = 6)
    private String gender;	
    @ApiModelProperty(position = 7)
    private String phone;
    @ApiModelProperty(position = 8)
    private List<Role> roles;
}
