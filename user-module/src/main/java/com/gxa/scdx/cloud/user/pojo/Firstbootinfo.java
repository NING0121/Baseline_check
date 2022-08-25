package com.gxa.scdx.cloud.user.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * (Firstbootinfo) pojo实体
 *
 * @author 王研博 easycode生成
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

@ApiModel(value = "Firstbootinfo", description = "$tableInfo.comment")
public class Firstbootinfo implements Serializable {
    private static final long serialVersionUID = 496497064991489467L;

    @ApiModelProperty(name = "id", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(name = "autorunIten", notes = "${column.comment}", dataType = "String", required = true)
    private String autorunIten;

    @ApiModelProperty(name = "path", notes = "${column.comment}", dataType = "String", required = true)
    private String path;

    @ApiModelProperty(name = "deviceId", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer deviceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutorunIten() {
        return autorunIten;
    }

    public void setAutorunIten(String autorunIten) {
        this.autorunIten = autorunIten;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

}
