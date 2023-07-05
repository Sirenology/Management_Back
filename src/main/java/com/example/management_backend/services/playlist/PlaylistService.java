package com.example.management_backend.services.playlist;

import com.example.management_backend.pojo.VO.PlaylistVO;

import java.util.List;

public interface PlaylistService {
    List<PlaylistVO> getAllPlaylistInfo();
    void createPlaylist(Integer userId,String playlistname);
    List<PlaylistVO> getAllPlaylistByUserId(Integer userId);
}