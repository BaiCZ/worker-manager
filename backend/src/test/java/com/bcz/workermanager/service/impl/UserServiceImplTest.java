package com.bcz.workermanager.service.impl;

import com.bcz.workermanager.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void getUserInfo() {
    }
}