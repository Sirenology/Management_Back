package com.example.management_backend.services.album.Impl;



import cn.hutool.log.Log;
import com.example.management_backend.mappers.AlbumMapper;
import com.example.management_backend.pojo.PO.AlbumPO;
import com.example.management_backend.pojo.VO.AlbumVO;
import com.example.management_backend.services.album.AlbumService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;




@Service
public class AlbumServiceImpl implements AlbumService{
    private final static Log log = Log.get();

    @Resource
    private AlbumMapper AlbumMapper;

    @Override
    public List<AlbumVO> getAllAlbumInfo() {
        log.info("正在获取所有专辑信息。");
        List<AlbumPO> albumPOList = AlbumMapper.selectList(null);
        List<AlbumVO> albumVOList = new ArrayList<>();
        for (AlbumPO albumPO : albumPOList) {
            AlbumVO albumVO = new AlbumVO();
            BeanUtils.copyProperties(albumPO, albumVO);
            albumVOList.add(albumVO);
        }
        return albumVOList;
    }

    @Override
    public void deleteAlbum(Integer albumId) {
        log.info("正在删除专辑{}信息。", albumId);
        AlbumMapper.deleteById(albumId);
    }

    @Override
    public void modifyAlbum(Integer albumId, String albumName) {
        log.info("正在修改专辑{}信息。", albumId);
        AlbumPO albumPO = AlbumMapper.selectById(albumId);
        log.info(albumPO.toString());
        albumPO.setTitle(albumName);
        AlbumMapper.updateById(albumPO);
    }

    @Override
    public List<AlbumVO> searchAlbum(String keyWord) {
        log.info("正在查询{}", keyWord);
        List<AlbumPO> albumPOList = AlbumMapper.searchAlbum(keyWord);
        log.info(albumPOList.toString());
        List<AlbumVO> albumVOList = new ArrayList<>();
        for (AlbumPO albumPOListItem : albumPOList) {
            AlbumVO albumVOListItem = new AlbumVO();
            BeanUtils.copyProperties(albumPOListItem, albumVOListItem);
            albumVOList.add(albumVOListItem);
        }
        return albumVOList ;
    }


}
