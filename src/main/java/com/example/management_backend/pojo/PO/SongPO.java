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
 * 歌曲表
 *
 * @TableName song
 */
@TableName(value = "song")
@Data
@ToString
@EqualsAndHashCode
public class SongPO implements Serializable {
    /**
     * 歌曲id
     */
    @TableId(type = IdType.AUTO)
    private Integer songId;
    
    /**
     * 歌曲名
     */
    private String title;
    
    /**
     * 歌手
     */
    private String artist;
    
    /**
     * 专辑
     */
    private String album;

}
