package com.example.management_backend.services.album;
import com.example.management_backend.pojo.VO.AlbumVO;
import com.example.management_backend.pojo.VO.SongVO;

import java.util.List;
public interface AlbumService {
    List<AlbumVO> getAllAlbumInfo();
    void deleteAlbum(Integer albumId);
    void modifyAlbum(Integer albumId, String albumName);

    List<AlbumVO> searchAlbum(String keyWord);
}
