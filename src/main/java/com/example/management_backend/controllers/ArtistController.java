package com.example.management_backend.controllers;

import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.DTO.artist.ArtistDTO;
import com.example.management_backend.pojo.DTO.common.CommonDTO;
import com.example.management_backend.pojo.VO.ArtistVO;
import com.example.management_backend.services.artist.ArtistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Options;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/artist")
@Api(tags = "歌手接口")
@Validated
public class ArtistController {

    //注入bing
    @Resource
    private ArtistService artistService;

    private static final Log log = Log.get();

    @PostMapping ("/getAllArtistInfo")
    @ApiOperation(value = "获取所有歌手信息", notes = "获取所有歌手信息")
    public CommonResponse<List<ArtistVO>> getAllArtistInfo(){
        log.info("---[歌手接口-【获取所有歌手】]：---");
        List<ArtistVO> artistInfo = artistService.getAllArtistInfo();
        return CommonResponse.createSuccess(artistInfo);
    }

    @PostMapping("/deleteArtist")
    @ApiOperation(value = "删除歌手", notes = "删除歌手")
    public CommonResponse<Void> deleteArtist(@RequestBody CommonDTO commonDTO) {
        artistService.deleteArtist(commonDTO.getArtistId());
        return CommonResponse.create(null, "SUCCESS");
    }

    @PostMapping ("/createArtist")
    @ApiOperation(value = "创建歌手", notes = "创建歌手")
    public CommonResponse<Void> createArtist(@RequestBody @Validated ArtistDTO artistDTO){
        log.info("---[歌单接口-【创建歌单】]：---");
        artistService.createArtist(artistDTO.getArtist());
        return CommonResponse.create(null, "创建成功");
    }
}
