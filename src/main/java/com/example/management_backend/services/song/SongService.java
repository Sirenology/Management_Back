package com.example.management_backend.services.song;

import com.example.management_backend.pojo.VO.SongVO;
import java.util.List;

/**
 * @author Sirenology
 * @description 针对表【song(歌曲表)】的数据库操作Service
 */
public interface SongService {
    List<SongVO> getAllSongInfo();
    List<SongVO> getAllSongInfoByUserId(Integer UserId);
    List<SongVO> getAllSongByPlaylistId(Integer playlistId);
    void deleteSong(Integer songId);
    List<SongVO> searchSong(String keyWord);
}
