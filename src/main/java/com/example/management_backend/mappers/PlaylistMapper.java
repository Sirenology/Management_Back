package com.example.management_backend.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.management_backend.pojo.PO.PlaylistPO;
import com.example.management_backend.pojo.PO.SongPO;

import java.util.List;

public interface PlaylistMapper extends BaseMapper<PlaylistPO> {
    List<PlaylistPO> selectPlaylistByUserId(Integer userId);
}
