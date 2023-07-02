package com.example.management_backend.controllers.song;


import cn.hutool.log.Log;
import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.pojo.VO.UserVO;
import com.example.management_backend.services.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Options;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping ("/getAllUserInfo")
    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    public CommonResponse<List<UserVO>> getAllUserInfo(){
        log.info("---[用户接口-【获取所有用户信息】]：---");
        List<UserVO> userInfo = userService.getAllUserInfo();
        return CommonResponse.createSuccess(userInfo);
    }
}
