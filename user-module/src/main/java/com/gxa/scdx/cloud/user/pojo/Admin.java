package com.gxa.scdx.cloud.user.pojo;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * (Admin) pojo实体
 *
 * @author 代宇盛 easycode生成 联合查询
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */


@ApiModel(value = "Admin", description = "$tableInfo.comment")
public class Admin implements Serializable {
    private static final long serialVersionUID = 495601109469668587L;

    @ApiModelProperty(name = "id", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(name = "adminName", notes = "${column.comment}", dataType = "String", required = true)
    private String adminName;

    @ApiModelProperty(name = "adminPwd", notes = "${column.comment}", dataType = "String", required = true)
    private String adminPwd;

    @ApiModelProperty(name = "adminPhone", notes = "${column.comment}", dataType = "String", required = true)
    private String adminPhone;

    @ApiModelProperty(name = "adminStatus", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer adminStatus;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    // 下面是服务器响应返回的内容，如果没有格式化转换，那么返回的内容是长毫秒数，接收mysql数据库中的数据也需要设置东八区+8时
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "lastLoginTime", notes = "${column.comment}", dataType = "Date", required = true)
    private Date lastLoginTime;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    // 下面是服务器响应返回的内容，如果没有格式化转换，那么返回的内容是长毫秒数，接收mysql数据库中的数据也需要设置东八区+8时
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "createTime", notes = "${column.comment}", dataType = "Date", required = true)
    private Date createTime;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    // 下面是服务器响应返回的内容，如果没有格式化转换，那么返回的内容是长毫秒数，接收mysql数据库中的数据也需要设置东八区+8时
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "updateTime", notes = "${column.comment}", dataType = "Date", required = true)
    private Date updateTime;

    @ApiModelProperty(name = "isDeleted", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer isDeleted;

    @ApiModelProperty(name = "departmentId", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer departmentId;

    @ApiModelProperty(name = "roleId", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer roleId;

    public Admin() {
    }

    public Admin(String adminName, String adminPwd) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
    }

    public Admin(String adminName, String adminPwd, Integer roleId) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.roleId = roleId;
    }

    private Department department;
    private Role role;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
