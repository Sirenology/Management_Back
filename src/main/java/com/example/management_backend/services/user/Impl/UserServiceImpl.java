package com.example.management_backend.services.user.Impl;



import cn.hutool.log.Log;
import com.example.management_backend.mappers.UserMapper;
import com.example.management_backend.pojo.PO.UserPO;

import com.example.management_backend.pojo.VO.UserVO;
import com.example.management_backend.services.song.SongService;
import com.example.management_backend.services.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;



@Service
public class UserServiceImpl implements UserService {
    private final static Log log = Log.get();

    @Resource
    private UserMapper UserMapper;


    @Override
    public List<UserVO> getAllUserInfo() {
        log.info("正在获取所有用户信息。");
        List<UserPO> userPOList = UserMapper.selectList(null);
        List<UserVO> userVOList = new ArrayList<>();
        for (UserPO userPO : userPOList) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userPO, userVO);
            userVOList.add(userVO);
        }
        return userVOList;
    }

}
