package com.example.management_backend.controllers;


import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.DTO.user.UserDeleteDTO;
import com.example.management_backend.pojo.DTO.user.UserLoginDTO;
import com.example.management_backend.pojo.DTO.user.UserRegisterDTO;
import com.example.management_backend.pojo.PO.UserPO;
import com.example.management_backend.pojo.VO.UserLoginVO;
import com.example.management_backend.pojo.VO.UserVO;
import com.example.management_backend.services.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Options;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public CommonResponse<Void> deleteUser(@RequestBody UserDeleteDTO userDeleteDTO) {
        userService.deleteUser(userDeleteDTO.getUserName());
        return CommonResponse.create(null, "删除成功");
    }
}
