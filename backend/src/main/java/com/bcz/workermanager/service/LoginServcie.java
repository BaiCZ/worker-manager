package com.bcz.workermanager.service;

import com.bcz.workermanager.common.pojo.ResponseResult;
import com.bcz.workermanager.pojo.entity.User;

public interface LoginServcie {
    public ResponseResult login(User user);
    public ResponseResult logout();
}
