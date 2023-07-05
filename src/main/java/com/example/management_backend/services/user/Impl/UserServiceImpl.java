package com.example.management_backend.services.user.Impl;



import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management_backend.mappers.UserMapper;
import com.example.management_backend.pojo.PO.UserPO;

import com.example.management_backend.pojo.VO.UserLoginVO;
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

    @Override
    public String register(String userName, String password) {
        log.info("正在注册{}用户。",userName);
        UserPO userPOOld = UserMapper.selectOne(new QueryWrapper<UserPO>().eq("username", userName));
        if (userPOOld != null) {
            log.info("【Register】用户 {} 已存在。", userName);
            return "USER_EXISTS";
        }
        UserPO userPONew = new UserPO();
        userPONew.setUsername(userName);
        userPONew.setPassword(password);
        UserMapper.insert(userPONew);
        return "SUCCESS";
    }

    @Override
    public UserLoginVO login(String userName, String password) {
        log.info("正在登录{}用户。",userName);
        UserPO userPO = UserMapper.selectOne(new QueryWrapper<UserPO>().eq("username", userName));
        UserLoginVO userLoginVO = new UserLoginVO();
        if (userPO == null) {
            userLoginVO.setLogininfo("USER_NOT_EXISTS");
            return userLoginVO;
        }
        if (!userPO.getPassword().equals(password)) {
            userLoginVO.setLogininfo("PASSWORD_ERROR");
            return userLoginVO;
        }
        log.info("【Login】用户 {} 登录成功。", userName);
        BeanUtils.copyProperties(userPO, userLoginVO);
        userLoginVO.setLogininfo("SUCCESS");
        return userLoginVO;
    }

    @Override
    public void deleteUser(String userName) {
        log.info("正在删除{}用户。",userName);
        UserMapper.delete(new QueryWrapper<UserPO>().eq("username", userName));
    }

}
