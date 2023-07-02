package com.example.management_backend.services.playlist.lmpl;
import cn.hutool.log.Log;
import com.example.management_backend.mappers.PlaylistMapper;
import com.example.management_backend.mappers.SongMapper;
import com.example.management_backend.pojo.PO.PlaylistPO;
import com.example.management_backend.pojo.PO.SongPO;
import com.example.management_backend.pojo.VO.PlaylistVO;
import com.example.management_backend.pojo.VO.SongVO;
import com.example.management_backend.services.playlist.PlaylistService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
public class PlaylistServicelmpl implements PlaylistService {
    private final static Log log = Log.get();

    @Resource
    private com.example.management_backend.mappers.PlaylistMapper PlaylistMapper;

    @Override
    public List<PlaylistVO> getAllPlaylistInfo() {
        log.info("正在获取所有歌曲信息。");
        List<PlaylistPO> playlistPOList = PlaylistMapper.selectList(null);
        List<PlaylistVO> playlistVOList = new ArrayList<>();
        for (PlaylistPO playlistPO : playlistPOList) {
            PlaylistVO playlistVO = new PlaylistVO();
            BeanUtils.copyProperties(playlistPO, playlistVO);
            playlistVOList.add(playlistVO);
        }
        return playlistVOList;
    }
    @Override
    public List<PlaylistVO>  getCreateSongListInfo(Integer playlistId,String songListAvater,Integer userId){
        log.info("正在获取所有歌曲信息。");
        List<PlaylistPO> playlistPOList = PlaylistMapper.selectList(null);
        List<PlaylistVO> playlistVOList = new ArrayList<>();
        for (PlaylistPO playlistPO : playlistPOList) {
            PlaylistVO playlistVO = new PlaylistVO();
            BeanUtils.copyProperties(playlistPO, playlistVO);
            playlistVOList.add(playlistVO);
        }
        return playlistVOList;
    }
}
