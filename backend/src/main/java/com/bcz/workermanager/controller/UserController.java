package com.bcz.workermanager.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcz.workermanager.common.pojo.ResponseResult;
import com.bcz.workermanager.pojo.entity.User;
import com.bcz.workermanager.service.LoginServcie;
import com.bcz.workermanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.bcz.workermanager.common.pojo.ResponseResult.success;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2023-11-30 21:22:55
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    /**
     * 服务对象
     */
    private final UserService userService;
    private final LoginServcie loginServcie;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<User> page, User user) {
        return success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody User user) {
        return success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody User user) {
        return success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return success(this.loginServcie.login(user));
    }

    @GetMapping("/info")
    public ResponseResult getUserInfo() {
        return success(this.userService.getUserInfo());
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return success(this.loginServcie.logout());
    }
}

