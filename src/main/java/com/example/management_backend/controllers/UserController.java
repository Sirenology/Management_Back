package com.example.management_backend.controllers;


import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.DTO.common.CommonDTO;
import com.example.management_backend.pojo.DTO.search.SearchDTO;
import com.example.management_backend.pojo.DTO.user.UserLoginDTO;
import com.example.management_backend.pojo.DTO.user.UserRegisterDTO;
import com.example.management_backend.pojo.VO.UserLoginVO;
import com.example.management_backend.pojo.VO.UserVO;
import com.example.management_backend.services.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
@Validated
public class UserController {
    //注入bing
    @Resource
    private UserService userService;

    private static final Log log = Log.get();

    @PostMapping ("/getAllUserInfo")
    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    public CommonResponse<List<UserVO>> getAllUserInfo(){
        log.info("---[用户接口-【获取所有用户信息】]：---");
        List<UserVO> userInfo = userService.getAllUserInfo();
        return CommonResponse.createSuccess(userInfo);
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册用户", notes = "注册用户")
    public String register(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userService.register(userRegisterDTO.getUserName(), userRegisterDTO.getPassword());
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录用户", notes = "登录用户")
    public UserLoginVO login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO.getUserName(), userLoginDTO.getPassword());
    }

    @PostMapping("/deleteUser")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public CommonResponse<Void> deleteUser(@RequestBody CommonDTO commonDTO) {
        userService.deleteUser(commonDTO.getUserId());
        return CommonResponse.create(null, "SUCCESS");
    }

    @PostMapping("/modifyUser")
    @ApiOperation(value = "修改用户名", notes = "修改用户名")
    public CommonResponse<Void> modifyUser(@RequestBody CommonDTO commonDTO) {
        userService.modifyUser(commonDTO.getUserId(),commonDTO.getUsername());
        return CommonResponse.create(null, "SUCCESS");
    }

    @PostMapping("/searchUser")
    @ApiOperation(value = "搜索用户", notes = "搜索用户")
    public CommonResponse<List<UserVO>> searchUser(@RequestBody SearchDTO searchDTO) {
        List<UserVO> userVOList= userService.searchUser(searchDTO.getKeyWord());
        return CommonResponse.create(userVOList, "SUCCESS");
    }
}
