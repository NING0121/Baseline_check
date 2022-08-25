
package com.gxa.scdx.cloud.user.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * (Baselineinfo) pojo实体
 *
 * @author 王研博 easycode生成
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

@ApiModel(value = "Baselineinfo", description = "$tableInfo.comment")
public class Baselineinfo implements Serializable {
    private static final long serialVersionUID = -72151803333973007L;

    @ApiModelProperty(name = "id", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(name = "itemId", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer itemId;

    @ApiModelProperty(name = "itemName", notes = "${column.comment}", dataType = "String", required = true)
    private String itemName;

    @ApiModelProperty(name = "currentVal", notes = "${column.comment}", dataType = "String", required = true)
    private String currentVal;

    @ApiModelProperty(name = "recommendVal", notes = "${column.comment}", dataType = "String", required = true)
    private String recommendVal;

    @ApiModelProperty(name = "rule", notes = "${column.comment}", dataType = "String", required = true)
    private String rule;

    @ApiModelProperty(name = "result", notes = "${column.comment}", dataType = "String", required = true)
    private String result;

    @ApiModelProperty(name = "remediationPath", notes = "${column.comment}", dataType = "String", required = true)
    private String remediationPath;

    @ApiModelProperty(name = "note", notes = "${column.comment}", dataType = "String", required = true)
    private String note;

    @ApiModelProperty(name = "deviceId", notes = "${column.comment}", dataType = "Integer", required = true)
    private Integer deviceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(String currentVal) {
        this.currentVal = currentVal;
    }

    public String getRecommendVal() {
        return recommendVal;
    }

    public void setRecommendVal(String recommendVal) {
        this.recommendVal = recommendVal;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRemediationPath() {
        return remediationPath;
    }

    public void setRemediationPath(String remediationPath) {
        this.remediationPath = remediationPath;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

}
