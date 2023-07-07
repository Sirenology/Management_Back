package com.example.management_backend.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.management_backend.pojo.PO.UserPO;

import java.util.List;

public interface UserMapper extends BaseMapper<UserPO> {

    List<UserPO> searchUser(String keyWord);
}
