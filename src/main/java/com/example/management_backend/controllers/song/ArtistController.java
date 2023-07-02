package com.example.management_backend.controllers.song;

import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.VO.ArtistVO;
import com.example.management_backend.services.artist.ArtistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Options;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping ("/getAllArtistInfo")
    @ApiOperation(value = "获取所有歌手信息", notes = "获取所有歌手信息")
    public CommonResponse<List<ArtistVO>> getAllArtistInfo(){
        log.info("---[歌手接口-【获取所有歌手】]：---");
        List<ArtistVO> artistInfo = artistService.getAllArtistInfo();
        return CommonResponse.createSuccess(artistInfo);
    }


}
