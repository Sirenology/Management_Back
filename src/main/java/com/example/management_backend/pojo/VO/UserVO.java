package com.example.management_backend.pojo.VO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode
public class UserVO {
    @ApiModelProperty(value = "用户id")
    private Integer usernameid;
    @ApiModelProperty(value = "用户姓名")
    private String username;
}