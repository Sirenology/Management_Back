package com.example.management_backend.services.artist.lmpl;
import cn.hutool.log.Log;
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
    private com.example.management_backend.mappers.ArtistMapper ArtistMapper;

    @Override
    public List<ArtistVO> getAllArtistInfo() {
        log.info("正在获取所有歌手信息。");
        List<ArtistPO> artistPOList = ArtistMapper.selectList(null);
        List<ArtistVO> artistVOList = new ArrayList<>();
        for (ArtistPO artistPO : artistPOList) {
            ArtistVO artistVO = new ArtistVO();
            BeanUtils.copyProperties(artistPO, artistVO);
            artistVOList.add(artistVO);
        }
        return artistVOList;
    }
}
