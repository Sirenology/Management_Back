package com.example.management_backend.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.management_backend.pojo.PO.AlbumPO;

import java.util.List;


public interface AlbumMapper extends BaseMapper<AlbumPO> {

    List<AlbumPO> searchAlbum(String keyWord);
}
