package com.gxa.scdx.cloud.user.service.impl;

import com.gxa.scdx.cloud.user.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Admin)表服务实现类
 *
 * @author 林佳评
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public Map<String, Object> getAdminNum(){
        Map<String, Object> map = new HashMap<>();
        Integer normal_admin_num = 0;
        Integer super_admin_num = 0;
        Set<String> keys = this.redisTemplate.keys("*");
        for(String key : keys){
            Map<Object,Object> hash_map = this.redisTemplate.opsForHash().entries(key);
            Object role = hash_map.entrySet().iterator().next().getValue();
            if ((Integer)role == 0){
                normal_admin_num = normal_admin_num + 1;
            }
            else {
                super_admin_num = super_admin_num + 1;
            }
        }
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("normal_admin_num", normal_admin_num);
        map.put("super_admin_num", super_admin_num);
        return map;
    }

}
