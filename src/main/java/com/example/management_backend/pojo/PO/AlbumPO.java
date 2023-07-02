package com.example.management_backend.pojo.PO;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * 专辑表
 *
 * @TableName album
 */

@TableName(value = "album")
@Data
@ToString
@EqualsAndHashCode
public class AlbumPO implements Serializable{
    /**
     * 专辑id
     */
    @TableId(type = IdType.AUTO)
    private Integer albumId;


    /**
     * 专辑名
     */
    private String title;


    private String albumAvater;
}
