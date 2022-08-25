package com.gxa.scdx.cloud.user.dto;

/**
 * (ImageHijackinfo) dto对象
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */

public class ImageHijackinfo {
    private String original_file;

    public String getOriginal_file() {
        return original_file;
    }

    public void setOriginal_file(String original_file) {
        this.original_file = original_file;
    }

    public String getActual_executable_file() {
        return actual_executable_file;
    }

    public void setActual_executable_file(String actual_executable_file) {
        this.actual_executable_file = actual_executable_file;
    }

    private String actual_executable_file;

    public ImageHijackinfo() {
    }
}
