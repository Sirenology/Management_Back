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
        log.info("【getAllSongInfo】正在查询所有歌曲信息");
        List<SongPO> songPOList = SongMapper.selectList(null);
        return getSongVOList(songPOList);
    }
    @Override
    public List<SongVO> getAllSongInfoByUserId(Integer UserId){
        log.info("正在进行getAllSongListInfoByUser操作。");
        List<SongPO> songPOList = SongMapper.selectList(null);
        return getSongVOList(songPOList);
    }
    @Override
    public List<SongVO> getAllSongByPlaylistId(Integer playlistId) {
        log.info("正在获取{}歌单下所有歌曲信息。",playlistId);
        List<SongPO> songPOList = SongMapper.selectSongByPlaylistId(playlistId);
        return getSongVOList(songPOList);
    }

    private static List<SongVO> getSongVOList(List<SongPO> songPOList) {
        List<SongVO> songVOList = new ArrayList<>();
        for (SongPO songPOListItem : songPOList) {
            SongVO songVOListItem = new SongVO();
            BeanUtils.copyProperties(songPOListItem, songVOListItem);
            songVOList.add(songVOListItem);
        }
        return songVOList;
    }
}
