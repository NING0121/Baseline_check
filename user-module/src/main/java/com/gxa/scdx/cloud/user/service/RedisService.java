package com.gxa.scdx.cloud.user.service;

import java.util.Map;

/**
 * (Redis) 服务接口类
 *
 * @author 林佳评
 * @version 1.0
 * @since 2021-06-25 11:06:02
 */
public interface RedisService {
    /**
     * 获取超级管理员与普通管理员数量
     * @return
     */
    Map<String, Object> getAdminNum();
}
