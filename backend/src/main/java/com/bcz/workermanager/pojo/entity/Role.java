package com.bcz.workermanager.pojo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * (Role)表实体类
 *
 * @author makejava
 * @since 2023-11-30 21:06:44
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("角色")
public class Role extends Model<Role> {
    //角色ID
    @ApiModelProperty(value = "角色ID")
    @TableId(type = IdType.AUTO)
    private Integer roleId;
    //角色名称
    @ApiModelProperty(value = "角色名称")
    private String roleName;
}

