package com.example.management_backend.controllers;

import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.DTO.common.CommonDTO;
import com.example.management_backend.pojo.DTO.playlist.PlaylistDTO;
import com.example.management_backend.pojo.VO.PlaylistVO;
import com.example.management_backend.services.playlist.PlaylistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/playlist")
@Api(tags = "歌单接口")
@Validated
public class PlaylistController {

    //注入bing
    @Resource
    private PlaylistService playlistService;

    private static final Log log = Log.get();

    @GetMapping ("/getAllPlaylistInfo")
    @ApiOperation(value = "获取所有歌单信息", notes = "获取所有歌单信息")
    public CommonResponse<List<PlaylistVO>> getAllPlaylistInfo(){
        log.info("---[歌单接口-【获取所有歌单】]：---");
        List<PlaylistVO> playlistInfo = playlistService.getAllPlaylistInfo();
        return CommonResponse.createSuccess(playlistInfo);
    }

    @PostMapping ("/getAllPlaylistByUserId")
    @ApiOperation(value = "获取用户下所有歌单信息", notes = "获取用户下所有歌单信息")
    public CommonResponse<List<PlaylistVO>> getAllPlaylistByUserId(@RequestBody CommonDTO commonDTO){
        log.info("---[歌单接口-【获取{}歌单下所有歌曲信息】]：---",commonDTO.getUserId());
        List<PlaylistVO> playlistList = playlistService.getAllPlaylistByUserId(commonDTO.getUserId());
        return CommonResponse.create(playlistList, "获取成功");
    }

    @PostMapping ("/createPlaylist")
    @ApiOperation(value = "创建歌单", notes = "创建歌单")
    public CommonResponse<Void> createPlaylist(@RequestBody @Validated PlaylistDTO playlistDTO){
        log.info("---[歌单接口-【创建歌单】]：---");
        playlistService.createPlaylist(playlistDTO.getUserId(), playlistDTO.getPlaylistname());
        return CommonResponse.create(null, "创建成功");
    }

}
