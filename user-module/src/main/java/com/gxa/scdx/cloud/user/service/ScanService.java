/**
 * @Author: 王研博
 *
 */
package com.gxa.scdx.cloud.user.service;

import java.util.Map;
/**
 * (Scan)表服务接口类
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:02
 */
public interface ScanService {
    Map<String, Object> selectByDeviceId(Integer id);
    Map<String, Object> updateByDeviceId(Integer id, Integer value);
}
