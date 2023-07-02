package com.example.management_backend.controllers.song;

import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.DTO.PlaylistListDTO;
import com.example.management_backend.pojo.VO.PlaylistVO;
import com.example.management_backend.pojo.VO.SongVO;
import com.example.management_backend.services.playlist.PlaylistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    @GetMapping ("/getCreateSongListInfo")
    @ApiOperation(value = "获取创建歌单信息", notes = "获取创建歌单信息")
    public CommonResponse<List<PlaylistVO>> getCreateSongListInfo (@RequestBody @Validated PlaylistListDTO songListDTO, HttpServletRequest request){
        List<PlaylistVO> playlistInfo = playlistService.getCreateSongListInfo(songListDTO.getPlayListId(),songListDTO.getSongListAvater(),songListDTO.getUserId());
        return CommonResponse.createSuccess(playlistInfo);
    }

}
