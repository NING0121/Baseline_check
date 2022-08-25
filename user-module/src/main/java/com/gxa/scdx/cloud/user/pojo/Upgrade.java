package com.gxa.scdx.cloud.user.pojo;


/**
 * (Upgrade) pojo实体
 *
 * @author 林佳评
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

public class Upgrade {
    /**
     * 申请用户的名称
     */
    private String username;
    /**
     * 处理状态：接受，拒绝，待处理
     */
    private String state;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
