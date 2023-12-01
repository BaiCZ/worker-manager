package com.bcz.workermanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bcz.workermanager.pojo.entity.Emp;
import com.bcz.workermanager.mapper.EmpMapper;
import com.bcz.workermanager.service.EmpService;
import org.springframework.stereotype.Service;

/**
 * (Emp)表服务实现类
 *
 * @author makejava
 * @since 2023-11-30 13:11:03
 */
@Service("empService")
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}

