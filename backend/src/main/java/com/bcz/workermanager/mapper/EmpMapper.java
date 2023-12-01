package com.bcz.workermanager.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.bcz.workermanager.pojo.entity.Emp;

/**
 * (Emp)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-30 13:11:01
 */
public interface EmpMapper extends BaseMapper<Emp> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<Emp> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<Emp> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<Emp> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<Emp> entities);

}
