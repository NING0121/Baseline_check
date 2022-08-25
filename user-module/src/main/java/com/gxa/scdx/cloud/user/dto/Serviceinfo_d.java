package com.gxa.scdx.cloud.user.dto;

/**
 * (Serviceinfo_d) dto对象
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */

public class Serviceinfo_d {
    public Serviceinfo_d() {
    }



    private String display_name;
    private String service_name;
    private String start_type;
    private String state;

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getStart_type() {
        return start_type;
    }

    public void setStart_type(String start_type) {
        this.start_type = start_type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBinary_path_name() {
        return binary_path_name;
    }

    public void setBinary_path_name(String binary_path_name) {
        this.binary_path_name = binary_path_name;
    }

    private String binary_path_name;
}
