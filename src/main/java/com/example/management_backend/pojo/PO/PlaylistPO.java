package com.example.management_backend.pojo.PO;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.ibatis.annotations.Options;

import java.io.Serializable;



@TableName(value = "song")
@Data
@ToString
@EqualsAndHashCode


public class PlaylistPO implements Serializable{
    /**
     * 歌单id
     */
    @TableId(type = IdType.AUTO)
    private Integer playListId;

    /**
     * 歌单名
     */
    private String playlistName;
    private String songListAvater;
}
