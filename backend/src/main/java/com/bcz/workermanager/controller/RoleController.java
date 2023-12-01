package com.bcz.workermanager.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcz.workermanager.common.pojo.ResponseResult;
import com.bcz.workermanager.pojo.entity.Role;
import com.bcz.workermanager.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.bcz.workermanager.common.pojo.ResponseResult.success;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2023-11-30 21:06:44
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param role 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Role> page, Role role) {
        return success(this.roleService.page(page, new QueryWrapper<>(role)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return success(this.roleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param role 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Role role) {
        return success(this.roleService.save(role));
    }

    /**
     * 修改数据
     *
     * @param role 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Role role) {
        return success(this.roleService.updateById(role));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.roleService.removeByIds(idList));
    }
}

