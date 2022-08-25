package com.gxa.scdx.cloud.user.exception;

/**
 * (ResultDTO) dto对象
 *
 * @author all;
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */

public class LoginExcetion extends RuntimeException {

    private Integer code;

    private String msg;

    public LoginExcetion() {
    }

    public LoginExcetion( Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
