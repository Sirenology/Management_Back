package com.example.management_backend.services.artist.lmpl;
import cn.hutool.log.Log;
import com.example.management_backend.mappers.ArtistMapper;
import com.example.management_backend.pojo.PO.ArtistPO;
import com.example.management_backend.pojo.VO.ArtistVO;
import com.example.management_backend.services.artist.ArtistService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final static Log log = Log.get();

    @Resource
    private ArtistMapper artistMapper;

    @Override
    public List<ArtistVO> getAllArtistInfo() {
        log.info("正在获取所有歌手信息。");
        List<ArtistPO> artistPOList = artistMapper.selectList(null);
        List<ArtistVO> artistVOList = new ArrayList<>();
        for (ArtistPO artistPO : artistPOList) {
            ArtistVO artistVO = new ArtistVO();
            BeanUtils.copyProperties(artistPO, artistVO);
            artistVOList.add(artistVO);
        }
        return artistVOList;
    }

    @Override
    public void deleteArtist(Integer artistId){
        log.info("正在删除歌手{}信息。", artistId);
        artistMapper.deleteById(artistId);
    }

    @Override
    public void createArtist(String artist) {
        log.info("管理员正在创建歌手:{}。",artist);
        ArtistPO artistPO = new ArtistPO();
        artistPO.setArtistname(artist);
        artistMapper.insert(artistPO);
    }

    @Override
    public List<ArtistVO> searchArtist(String keyWord) {
        log.info("正在查询{}", keyWord);
        List<ArtistPO> artistPOList = artistMapper.searchArtist(keyWord);
        log.info(artistPOList.toString());
        List<ArtistVO> artistVOList = new ArrayList<>();
        for (ArtistPO artistPOListItem : artistPOList) {
            ArtistVO artistVOListItem = new ArtistVO();
            BeanUtils.copyProperties(artistPOListItem, artistVOListItem);
            artistVOList.add(artistVOListItem);
        }
        return artistVOList ;
    }

}
