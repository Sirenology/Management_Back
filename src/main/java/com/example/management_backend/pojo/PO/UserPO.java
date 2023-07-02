package com.example.management_backend.pojo.PO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.ibatis.annotations.Options;

import java.io.Serializable;

/**
        * 用户表
        *
        * @TableName user
        */
@TableName(value = "user")
@Data
@ToString
@EqualsAndHashCode
public class UserPO implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer usernameId;
    /**
     * 用户id
     */
    private String username;
    /**
     * 用户姓名
     */
    private String userAvater;
}
