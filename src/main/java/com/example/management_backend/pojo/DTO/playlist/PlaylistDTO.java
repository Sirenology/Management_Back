package com.example.management_backend.pojo.DTO.playlist;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class PlaylistDTO {
    @ApiModelProperty(value = "用户id", required = true)
    private Integer userId;
    @ApiModelProperty(value = "歌单名", required = true)
    private String playlistname;
}
