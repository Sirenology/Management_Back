package com.example.management_backend.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode
public class ArtistVO {
    @ApiModelProperty(value = "歌手id")
    private Integer artistId;
    @ApiModelProperty(value = "歌手名")
    private String artistname;
    @ApiModelProperty(value = "歌手头像")
    private String artistAvater;
}
