package com.example.management_backend.pojo.DTO.artist;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class ArtistDTO {
    @ApiModelProperty(value = "歌手名", required = true)
    private String artist;
}
