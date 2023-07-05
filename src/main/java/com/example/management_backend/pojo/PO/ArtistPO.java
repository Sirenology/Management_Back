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
 * @TableName artist
 */
@TableName(value = "artist")
@Data
@ToString
@EqualsAndHashCode
public class ArtistPO implements Serializable {
    /**
     * 歌手id
     */
    @TableId(type = IdType.AUTO)
    private Integer artistid;

    /**
     * 歌手名
     */
    private String artistname;
}
