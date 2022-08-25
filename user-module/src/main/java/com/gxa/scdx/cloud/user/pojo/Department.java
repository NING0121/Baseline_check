package com.gxa.scdx.cloud.user.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * (Department) pojo实体
 *
 * @author 代宇盛 easycode生成 联合查询
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */


@ApiModel(value = "Department", description = "$tableInfo.comment")
public class Department implements Serializable {
    private static final long serialVersionUID = -40447170436840924L;

    @ApiModelProperty(name = "id", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(name = "departmentName", notes = "${column.comment}", dataType = "String", required = true)
    private String departmentName;

    @ApiModelProperty(name = "departmentNumber", notes = "${column.comment}", dataType = "String", required = true)
    private String departmentNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

}
