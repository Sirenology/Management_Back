package com.example.management_backend.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode
public class SongVO {
    @ApiModelProperty(value = "歌曲id")
    private Integer songid;
    @ApiModelProperty(value = "歌曲名")
    private String title;
    @ApiModelProperty(value = "歌手")
    private String artist;
}
