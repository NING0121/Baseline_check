/**
 * @Author: 王研博
 *
 */
/**
 * @author 代宇盛
 */
package com.gxa.scdx.cloud.user.dto;


/**
 * (ResultDTO) dto对象
 *
 * @author all;
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */


public class ResultDTO {

    private Integer code;

    private String msg;

    private Object data;

    public ResultDTO() {
    }

    public ResultDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultDTO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
