package com.gxa.scdx.cloud.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * (Patchinfo_d) dto对象
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */

public class Patchinfo_d {
    public Patchinfo_d() {
    }

    public String getPatch_id() {
        return patch_id;
    }

    public void setPatch_id(String patch_id) {
        this.patch_id = patch_id;
    }

    public Date getInstalled_on() {
        return installed_on;
    }

    public void setInstalled_on(Date installed_on) {
        this.installed_on = installed_on;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstalled_by() {
        return installed_by;
    }

    public void setInstalled_by(String installed_by) {
        this.installed_by = installed_by;
    }

    private String patch_id;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="dd/MM/yyyy")
    private Date installed_on;
    private String description;
    private String installed_by;
}
