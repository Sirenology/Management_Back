package com.example.management_backend.services.user;

import com.example.management_backend.pojo.VO.UserVO;

import java.util.List;
public interface UserService {
    List<UserVO> getAllUserInfo();
}
