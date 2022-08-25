package com.gxa.scdx.cloud.user.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * (Patchinfo) pojo实体
 *
 * @author 王研博 easycode生成
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

@ApiModel(value = "Patchinfo", description = "$tableInfo.comment")
public class Patchinfo implements Serializable {
    private static final long serialVersionUID = 116602176755814635L;

    @ApiModelProperty(name = "patchId", notes = "${column.comment}", dataType = "String", required = true)
    private String patchId;

    @ApiModelProperty(name = "installedOn", notes = "${column.comment}", dataType = "String", required = true)
    private String installedOn;

    @ApiModelProperty(name = "description", notes = "${column.comment}", dataType = "String", required = true)
    private String description;

    @ApiModelProperty(name = "installedBy", notes = "${column.comment}", dataType = "String", required = true)
    private String installedBy;

    @ApiModelProperty(name = "id", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(name = "deviceId", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer deviceId;


    public String getPatchId() {
        return patchId;
    }

    public void setPatchId(String patchId) {
        this.patchId = patchId;
    }

    public String getInstalledOn() {
        return installedOn;
    }

    public void setInstalledOn(String installedOn) {
        this.installedOn = installedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstalledBy() {
        return installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

}
