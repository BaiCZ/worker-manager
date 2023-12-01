package com.bcz.workermanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bcz.workermanager.common.pojo.ResponseResult;
import com.bcz.workermanager.pojo.entity.User;
import com.bcz.workermanager.pojo.vo.UserInfoVo;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-11-30 21:22:59
 */
public interface UserService extends IService<User> {
    public UserInfoVo getUserInfo();
    public Integer getTokenUserId();

}

