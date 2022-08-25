
package com.gxa.scdx.cloud.user.service.impl;

import com.gxa.scdx.cloud.user.mapper.ScanMapper;
import com.gxa.scdx.cloud.user.service.ScanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (scan) 服务实现类
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */
@Service("scanService")
public class ScanServiceImpl implements ScanService {
    @Resource
    private ScanMapper scanMapper;
    public Map<String, Object> selectByDeviceId(Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("data", this.scanMapper.selectByDeviceId(id));
        return map;
    }
    public Map<String, Object> updateByDeviceId(Integer id, Integer value){
        this.scanMapper.updateByDeviceId(id, value);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "更新成功");
        return map;
    }

}
