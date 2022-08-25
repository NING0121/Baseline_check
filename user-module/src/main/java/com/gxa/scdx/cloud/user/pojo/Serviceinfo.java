package com.gxa.scdx.cloud.user.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * (Serviceinfo) pojo实体
 *
 * @author 王研博 easycode生成
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

@ApiModel(value = "Serviceinfo", description = "$tableInfo.comment")
public class Serviceinfo implements Serializable {
    private static final long serialVersionUID = -88589461329601177L;

    @ApiModelProperty(name = "id", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(name = "displayName", notes = "${column.comment}", dataType = "String", required = true)
    private String displayName;

    @ApiModelProperty(name = "serviceName", notes = "${column.comment}", dataType = "String", required = true)
    private String serviceName;

    @ApiModelProperty(name = "startType", notes = "${column.comment}", dataType = "String", required = true)
    private String startType;

    @ApiModelProperty(name = "state", notes = "${column.comment}", dataType = "String", required = true)
    private String state;

    @ApiModelProperty(name = "binaryPathName", notes = "${column.comment}", dataType = "String", required = true)
    private String binaryPathName;

    @ApiModelProperty(name = "deviceId", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer deviceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStartType() {
        return startType;
    }

    public void setStartType(String startType) {
        this.startType = startType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBinaryPathName() {
        return binaryPathName;
    }

    public void setBinaryPathName(String binaryPathName) {
        this.binaryPathName = binaryPathName;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

}
