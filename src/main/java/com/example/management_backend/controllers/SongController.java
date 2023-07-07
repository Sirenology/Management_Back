package com.example.management_backend.controllers;


import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.DTO.artist.ArtistDTO;
import com.example.management_backend.pojo.DTO.common.CommonDTO;
import com.example.management_backend.pojo.DTO.playlist.PlaylistDTO;
import com.example.management_backend.pojo.DTO.search.SearchDTO;
import com.example.management_backend.pojo.VO.SongVO;
import com.example.management_backend.services.song.SongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.DecimalMin;
import java.util.List;

@RestController
@RequestMapping("/song")
@Api(tags = "歌曲接口")
@Validated
public class SongController {

    //注入bing
    @Resource
    private SongService songService;

    private static final Log log = Log.get();

    @PostMapping ("/getAllSongInfo")
    @ApiOperation(value = "获取所有歌曲信息", notes = "获取所有歌曲信息")
    public CommonResponse<List<SongVO>> getAllSongInfo(){
        log.info("---[歌曲接口-【获取所有歌曲】]：---");
        List<SongVO> songList = songService.getAllSongInfo();
        return CommonResponse.create(songList, "获取成功");
    }

    @GetMapping ("/getAllSongListInfoByUser")
    @ApiOperation(value = "获取用户下所有歌曲信息", notes = "获取用户下所有歌曲信息")
    public CommonResponse<List<SongVO>> getAllSongListInfoByUserId(@RequestParam @DecimalMin(value = "0", message = "所属任务ID不合法") Integer UserId){
        log.info("---[歌曲接口-【获取该用户下所有歌曲信息】]：---");
        List<SongVO> songInfo = songService.getAllSongInfoByUserId(UserId);
        return CommonResponse.createSuccess(songInfo);
    }

    @PostMapping ("/getAllSongByPlaylistId")
    @ApiOperation(value = "获取歌单下所有歌曲信息", notes = "获取歌单下所有歌曲信息")
    public CommonResponse<List<SongVO>> getAllSongByPlaylistId(@RequestBody CommonDTO commonDTO){
        log.info("---[歌单接口-【获取{}歌单下所有歌曲信息】]：---",commonDTO.getPlaylistId());
        List<SongVO> songList = songService.getAllSongByPlaylistId(commonDTO.getPlaylistId());
        return CommonResponse.create(songList, "获取成功");
    }

    @PostMapping("/deleteSong")
    @ApiOperation(value = "删除歌曲", notes = "删除歌曲")
    public CommonResponse<Void> deleteSong(@RequestBody CommonDTO commonDTO) {
        songService.deleteSong(commonDTO.getSongId());
        return CommonResponse.create(null, "SUCCESS");
    }

    @PostMapping("/searchSong")
    @ApiOperation(value = "搜索歌曲", notes = "搜索歌曲")
    public CommonResponse<List<SongVO>> searchAlbum(@RequestBody SearchDTO searchDTO) {
        List<SongVO> songVOList= songService.searchSong(searchDTO.getKeyWord());
        return CommonResponse.create(songVOList, "SUCCESS");
    }


}
