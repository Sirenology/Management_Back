package com.example.management_backend.pojo.PO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


import java.io.Serializable;

@TableName(value = "playlist")
@Data
@ToString
@EqualsAndHashCode
public class PlaylistPO implements Serializable{
    /**
     * 歌单id
     */
    @TableId(type = IdType.AUTO)
    private Integer playlistid;

    /**
     * 歌单名
     */
    private String playlistname;

    /**
     * 用户id
     */
    private Integer usernameid;
}
