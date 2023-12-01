package com.bcz.workermanager.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@ApiModel("用户信息")
public class UserInfoVo {
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "角色")
    private List<String> roles;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "介绍")
    private String introduction;
}
