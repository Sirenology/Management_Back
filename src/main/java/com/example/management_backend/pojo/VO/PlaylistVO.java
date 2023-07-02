package com.example.management_backend.pojo.VO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode
public class PlaylistVO {
    @ApiModelProperty(value = "歌单id")
    private Integer playlistId;
    @ApiModelProperty(value = "歌单名")
    private String playlistName;
    @ApiModelProperty(value = "歌单封面")
    private String songListAvater;
}