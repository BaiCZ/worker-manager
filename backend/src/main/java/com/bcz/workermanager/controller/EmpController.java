package com.bcz.workermanager.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcz.workermanager.common.pojo.ResponseResult;
import com.bcz.workermanager.pojo.entity.Emp;
import com.bcz.workermanager.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.bcz.workermanager.common.pojo.ResponseResult.success;

/**
 * (Emp)表控制层
 *
 * @author makejava
 * @since 2023-11-30 13:11:01
 */
@Api(tags = "职工功能接口")
@RestController
@RequestMapping("emp")
public class EmpController{
    /**
     * 服务对象
     */
    @Resource
    private EmpService empService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param emp 查询实体
     * @return 所有数据
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseResult selectAll(Page<Emp> page, Emp emp) {
        return success(this.empService.page(page, new QueryWrapper<>(emp)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过id查询")
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return success(this.empService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param emp 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增职工")
    @PostMapping
    public ResponseResult insert(@RequestBody Emp emp) {
        return success(this.empService.save(emp));
    }

    /**
     * 修改数据
     *
     * @param emp 实体对象
     * @return 修改结果
     */
    @ApiOperation("职工更新")
    @PutMapping
    public ResponseResult update(@RequestBody Emp emp) {
        return success(this.empService.updateById(emp));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation("职工删除")
    @DeleteMapping
    public ResponseResult delete(@RequestParam("id") List<Long> idList) {
        return success(this.empService.removeByIds(idList));
    }
}

