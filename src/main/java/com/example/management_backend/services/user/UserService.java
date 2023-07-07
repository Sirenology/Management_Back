package com.example.management_backend.services.user;

import com.example.management_backend.pojo.VO.UserLoginVO;
import com.example.management_backend.pojo.VO.UserVO;

import java.util.List;
public interface UserService {
    List<UserVO> getAllUserInfo();
    String register(String userName, String password);
    UserLoginVO login(String userName, String password);
    void deleteUser(Integer userId);
    void modifyUser(Integer userId, String username);

    List<UserVO> searchUser(String keyWord);

}
