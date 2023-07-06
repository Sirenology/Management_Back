package com.example.management_backend.pojo.DTO.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class CommonDTO {
    @ApiModelProperty(value = "用户id", required = false)
    private Integer userId;
    @ApiModelProperty(value = "歌手id", required = false)
    private Integer artistId;
    @ApiModelProperty(value = "专辑id", required = false)
    private Integer albumId;
    @ApiModelProperty(value = "歌曲id", required = false)
    private Integer songId;
    @ApiModelProperty(value = "歌单id", required = false)
    private Integer playlistId;
    @ApiModelProperty(value = "用户名", required = false)
    private String username;
    @ApiModelProperty(value = "歌手名", required = false)
    private String artist;
    @ApiModelProperty(value = "专辑名", required = false)
    private String albumName;
    @ApiModelProperty(value = "歌曲名", required = false)
    private String title;
}
