package com.example.management_backend.services.song.Impl;

import cn.hutool.log.Log;
import com.example.management_backend.mappers.SongMapper;
import com.example.management_backend.pojo.PO.SongPO;
import com.example.management_backend.pojo.VO.SongVO;
import com.example.management_backend.services.song.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final static Log log = Log.get();

    @Resource
    private SongMapper SongMapper;

    @Override
    public List<SongVO> getAllSongInfo() {
        log.info("正在获取所有歌曲信息。");
        List<SongPO> songPOList = SongMapper.selectList(null);
        List<SongVO> songVOList = new ArrayList<>();
        for (SongPO songPO : songPOList) {
            SongVO songVO = new SongVO();
            BeanUtils.copyProperties(songPO, songVO);
            songVOList.add(songVO);
        }
        return songVOList;
    }

}
