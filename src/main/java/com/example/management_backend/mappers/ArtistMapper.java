package com.example.management_backend.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.management_backend.pojo.PO.ArtistPO;

import java.util.List;

public interface ArtistMapper extends BaseMapper<ArtistPO> {

    List<ArtistPO> searchArtist(String keyWord);

}
