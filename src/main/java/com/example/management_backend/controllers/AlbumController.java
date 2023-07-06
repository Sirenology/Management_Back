package com.example.management_backend.controllers;

import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.DTO.common.CommonDTO;
import com.example.management_backend.pojo.VO.AlbumVO;
import com.example.management_backend.services.album.AlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Options;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/album")
@Api(tags = "专辑接口")
@Validated
public class AlbumController {

    //注入bing
    @Resource
    private AlbumService albumService;

    private static final Log log = Log.get();

    @PostMapping("/getAllAlbumInfo")
    @ApiOperation(value = "获取所有专辑信息", notes = "获取所有专辑信息")
    public CommonResponse<List<AlbumVO>> getAllAlbumInfo() {
        log.info("---[专辑接口-【获取所有专辑】]：---");
        List<AlbumVO> albumInfo = albumService.getAllAlbumInfo();
        return CommonResponse.createSuccess(albumInfo);
    }

    @PostMapping("/deleteAlbum")
    @ApiOperation(value = "删除专辑", notes = "删除专辑")
    public CommonResponse<Void> deleteUser(@RequestBody CommonDTO commonDTO) {
        albumService.deleteAlbum(commonDTO.getAlbumId());
        return CommonResponse.create(null, "SUCCESS");
    }

    @PostMapping("/modifyAlbum")
    @ApiOperation(value = "修改专辑", notes = "修改专辑")
    public CommonResponse<Void> modifyAlbum(@RequestBody CommonDTO commonDTO) {
        albumService.modifyAlbum(commonDTO.getAlbumId(),commonDTO.getAlbumName());
        return CommonResponse.create(null, "SUCCESS");
    }
}

