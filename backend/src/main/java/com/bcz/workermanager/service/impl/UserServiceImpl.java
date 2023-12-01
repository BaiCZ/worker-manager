package com.bcz.workermanager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bcz.workermanager.common.pojo.ResponseResult;
import com.bcz.workermanager.mapper.UserMapper;
import com.bcz.workermanager.pojo.entity.LoginUser;
import com.bcz.workermanager.pojo.entity.Role;
import com.bcz.workermanager.pojo.entity.User;
import com.bcz.workermanager.pojo.vo.UserInfoVo;
import com.bcz.workermanager.service.RoleService;
import com.bcz.workermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-11-30 21:22:59
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private RoleService roleService;

    @Override
    public UserInfoVo getUserInfo() {
        User user = this.getById(getTokenUserId());
        List<Integer> roleIds = Arrays.stream(user.getRoleId().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Role> roles = roleService.list(new LambdaQueryWrapper<Role>().in(Role::getRoleId, roleIds));
        List<String> roleNames = roles.stream().map(Role::getRoleName).collect(Collectors.toList());
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserName(user.getUserName());
        userInfoVo.setAvatar(user.getAvatar());
        userInfoVo.setIntroduction(user.getIntroduction());
        userInfoVo.setRoles(roleNames);
        return userInfoVo;
    }

    @Override
    public Integer getTokenUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JSONObject principal = (JSONObject) authentication.getPrincipal();
        LoginUser loginUser = JSONObject.toJavaObject(principal,LoginUser.class);
        return loginUser.getUser().getUserId();
    }
}

