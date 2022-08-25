package com.gxa.scdx.cloud.user.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * (Role) pojo实体
 *
 * @author 代宇盛 easycode生成
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */
@ApiModel(value = "Role", description = "$tableInfo.comment")
public class Role implements Serializable {
    private static final long serialVersionUID = 888664907964980272L;

    @ApiModelProperty(name = "id", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(name = "roleName", notes = "${column.comment}", dataType = "String", required = true)
    private String roleName;

    @ApiModelProperty(name = "roleAuth", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer roleAuth;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleAuth() {
        return roleAuth;
    }

    public void setRoleAuth(Integer roleAuth) {
        this.roleAuth = roleAuth;
    }

}
