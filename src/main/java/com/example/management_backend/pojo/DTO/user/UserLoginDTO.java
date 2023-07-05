package com.example.management_backend.pojo.DTO.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class UserLoginDTO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
