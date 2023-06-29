package com.example.management_backend.services.song;

import com.example.management_backend.pojo.VO.SongVO;

import java.util.List;

/**
 * @author Sirenology
 * @description 针对表【song(歌曲表)】的数据库操作Service
 */
public interface SongService {
    List<SongVO> getAllSongInfo();
}
