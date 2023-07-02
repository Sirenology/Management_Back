package com.example.management_backend.pojo.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 歌曲表
 *
 * @TableName administrators
 */
@TableName(value = "administrators")
@Data
@ToString
@EqualsAndHashCode
public class ArtistPO implements Serializable {
    /**
     * 歌手id
     */
    @TableId(type = IdType.AUTO)
    private Integer artistId;

    /**
     * 歌手名
     */
    private String artistName;
    /**
     * 歌手头像
     */

    private String artistAvater;
}
