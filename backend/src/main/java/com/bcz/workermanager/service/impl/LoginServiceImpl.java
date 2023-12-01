package com.bcz.workermanager.service.impl;

import com.bcz.workermanager.common.pojo.ResponseResult;
import com.bcz.workermanager.common.utils.JwtUtil;
import com.bcz.workermanager.common.utils.RedisCache;
import com.bcz.workermanager.pojo.entity.LoginUser;
import com.bcz.workermanager.pojo.entity.User;
import com.bcz.workermanager.service.LoginServcie;
import com.bcz.workermanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginServcie {

    private final AuthenticationManager authenticationManager;
    private final RedisCache redisCache;
    private final UserService userService;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:" + userId, loginUser);
        //把token响应给前端
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return new ResponseResult(200, "登陆成功", map);
    }
    @Override
    public ResponseResult logout() {
        redisCache.deleteObject("login:"+userService.getTokenUserId());
        return new ResponseResult(200,"退出成功");
    }
}

