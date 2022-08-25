package com.gxa.scdx.cloud.user.dto;


/**
 * (FirstBootinfo_d) dto对象
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */
public class FirstBootinfo_d {
    public FirstBootinfo_d() {
    }

    public String getAutorun_item() {
        return autorun_item;
    }

    public void setAutorun_item(String autorun_item) {
        this.autorun_item = autorun_item;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String autorun_item;
    private String path;

}
