package com.example.management_backend.services.playlist;

import com.example.management_backend.pojo.VO.PlaylistVO;

import java.util.List;

public interface PlaylistService {
    List<PlaylistVO> getAllPlaylistInfo();
    List<PlaylistVO> getCreateSongListInfo(Integer playlistId,String songListAvater,Integer userId);
}
