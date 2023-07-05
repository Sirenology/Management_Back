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
    @ApiModelProperty(value = "歌单id", required = false)
    private Integer playlistId;
    @ApiModelProperty(value = "歌手id", required = false)
    private Integer artistId;
    @ApiModelProperty(value = "专辑id", required = false)
    private Integer albumId;


}
