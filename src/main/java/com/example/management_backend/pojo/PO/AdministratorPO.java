package com.example.management_backend.pojo.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 管理员表
 *
 * @TableName administrator
 */
@TableName(value = "administrators")
@Data
@ToString
@EqualsAndHashCode
public class AdministratorPO {
    /**
     * 管理员id
     */
    @TableId(type = IdType.AUTO)
    private Integer administratorid;

    /**
     * 用户id
     */
    private String usernameid;
}
