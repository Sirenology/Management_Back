package com.example.management_backend.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.management_backend.pojo.PO.SongPO;

import java.util.List;

/**
 * @description 针对表【song(歌曲表)】的数据库操作Mapper
 */

public interface SongMapper extends BaseMapper<SongPO> {
    List<SongPO> selectSongByPlaylistId(Integer playlistId);
}
