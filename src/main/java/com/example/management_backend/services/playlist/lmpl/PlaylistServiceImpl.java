package com.example.management_backend.services.playlist.lmpl;

import cn.hutool.log.Log;
import com.example.management_backend.mappers.PlaylistMapper;
import com.example.management_backend.pojo.PO.PlaylistPO;
import com.example.management_backend.pojo.VO.PlaylistVO;
import com.example.management_backend.services.playlist.PlaylistService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final static Log log = Log.get();

    @Resource
    private PlaylistMapper playlistMapper;

    @Override
    public List<PlaylistVO> getAllPlaylistInfo() {
        log.info("正在获取所有歌曲信息。");
        List<PlaylistPO> playlistPOList = playlistMapper.selectList(null);
        List<PlaylistVO> playlistVOList = new ArrayList<>();
        for (PlaylistPO playlistPO : playlistPOList) {
            PlaylistVO playlistVO = new PlaylistVO();
            BeanUtils.copyProperties(playlistPO, playlistVO);
            playlistVOList.add(playlistVO);
        }
        return playlistVOList;
    }
    @Override
    public void createPlaylist(Integer userId,String playlistname){
        log.info("{}用户正在创建{}歌单。",userId,playlistname);
        PlaylistPO playlistPO = new PlaylistPO();
        playlistPO.setPlaylistname(playlistname);
        playlistPO.setUsernameid(userId);
        playlistMapper.insert(playlistPO);
    }


    @Override
    public List<PlaylistVO> getAllPlaylistByUserId(Integer userId) {
        log.info("正在获取{}用户下所有歌曲信息。",userId);
        List<PlaylistPO> playlistPOList = playlistMapper.selectPlaylistByUserId(userId);
        List<PlaylistVO> playlistVOList = new ArrayList<>();
        for (PlaylistPO playlistPO : playlistPOList) {
            PlaylistVO playlistVO = new PlaylistVO();
            BeanUtils.copyProperties(playlistPO, playlistVO);
            playlistVOList.add(playlistVO);
        }
        return playlistVOList;
    }
}
