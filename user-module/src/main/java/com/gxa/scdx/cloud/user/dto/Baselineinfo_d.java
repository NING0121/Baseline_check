package com.gxa.scdx.cloud.user.dto;

/**
 * (Baselineinfo_d) dto对象
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */
public class Baselineinfo_d {
    public Baselineinfo_d()
    {

    }
    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getCurrent_val() {
        return current_val;
    }

    public void setCurrent_val(String current_val) {
        this.current_val = current_val;
    }

    public String getRecommend_val() {
        return recommend_val;
    }

    public void setRecommend_val(String recommend_val) {
        this.recommend_val = recommend_val;
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

    public String getRemediation_path() {
        return remediation_path;
    }

    public void setRemediation_path(String remediation_path) {
        this.remediation_path = remediation_path;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private int item_id;
    private String item_name;
    private String current_val;
    private String recommend_val;
    private String rule;
    private String result;
    private String remediation_path;
    private String note;
}
