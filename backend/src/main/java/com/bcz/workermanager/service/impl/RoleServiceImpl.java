package com.bcz.workermanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bcz.workermanager.mapper.RoleMapper;
import com.bcz.workermanager.pojo.entity.Role;
import com.bcz.workermanager.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2023-11-30 21:06:44
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

