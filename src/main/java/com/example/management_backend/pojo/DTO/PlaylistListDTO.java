package com.example.management_backend.pojo.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class PlaylistListDTO {
    @ApiModelProperty(value = "歌单名", required = true)
    private Integer playListId;

    @ApiModelProperty(value = "歌单封面", required = true)
    private String songListAvater;

    @ApiModelProperty(value = "用户id", required = true)
    private Integer userId;
}
