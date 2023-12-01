package com.bcz.workermanager.pojo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2023-11-30 21:22:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("用户")
public class User extends Model<User> {
    @ApiModelProperty(value = "用户ID")
    @TableId(type = IdType.AUTO)
    private Integer userId;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String password;
    //介绍
    @ApiModelProperty(value = "介绍")
    private String introduction;
    //头像
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "角色ID")
    private String roleId;

}

