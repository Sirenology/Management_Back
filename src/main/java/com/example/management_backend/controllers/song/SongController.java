package com.example.management_backend.controllers.song;

import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.VO.SongVO;
import com.example.management_backend.services.song.SongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Options;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @GetMapping ("/getAllSongInfo")
    @ApiOperation(value = "获取所有歌曲信息", notes = "获取所有歌曲信息")
    public CommonResponse<List<SongVO>> getAllSongInfo(){
        log.info("---[歌曲接口-【获取所有歌曲】]：---");
        List<SongVO> songInfo = songService.getAllSongInfo();
        return CommonResponse.createSuccess(songInfo);
    }

    @GetMapping ("/getAllSongListInfoByUser")
    @ApiOperation(value = "获取该用户下所有歌曲信息", notes = "获取该用户下所有歌曲信息")
    public CommonResponse<List<SongVO>> getAllSongListInfoByUserId(@RequestParam @DecimalMin(value = "0", message = "所属任务ID不合法") Integer UserId, HttpServletRequest request){
        log.info("---[歌曲接口-【获取该用户下所有歌曲信息】]：---");
        List<SongVO> songInfo = songService.getAllSongListInfoByUserId(UserId);
        return CommonResponse.createSuccess(songInfo);
    }

}
