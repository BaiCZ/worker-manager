package com.bcz.workermanager.pojo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * (Emp)表实体类
 *
 * @author makejava
 * @since 2023-11-30 13:11:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("职工")
public class Emp extends Model<Emp> {
    //职工ID
    @ApiModelProperty(value = "职工ID")
    @TableId(type = IdType.AUTO)
    private Integer empId;
    //职工名称
    @ApiModelProperty(value = "职工名称")
    private String empName;
    //性别
    @ApiModelProperty(value = "性别")
    private Integer sex;
    //年龄
    @ApiModelProperty(value = "年龄")
    private Integer age;
    //部门
    @ApiModelProperty(value = "部门")
    private String deptName;
    //学历
    @ApiModelProperty(value = "学历")
    private String empDegreeName;
}

