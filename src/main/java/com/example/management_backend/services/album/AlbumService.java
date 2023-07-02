package com.example.management_backend.services.album;
import com.example.management_backend.pojo.VO.AlbumVO;
import com.example.management_backend.pojo.VO.SongVO;

import java.util.List;
public interface AlbumService {
    List<AlbumVO> getAllAlbumInfo();
}
