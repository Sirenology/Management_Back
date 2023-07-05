package com.example.management_backend.pojo.VO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class AlbumVO {
    @ApiModelProperty(value = "专辑id")
    private Integer albumid;
    @ApiModelProperty(value = "专辑名")
    private String title;
}
