/**
 * @Author: 王研博
 *
 */
package com.gxa.scdx.cloud.user.service;


import com.gxa.scdx.cloud.user.pojo.Sysinfo_t;

import java.util.Map;

/**
 * (Patchinfo)表服务接口类
 *
 * @author 王研博 easycode生成
 * @author 林佳评 增加selectForPage，selectForCount接口
 * @version 1.0
 * @since 2021-06-25 11:06:02
 */
public interface SysinfoTService {
    Map<String, Object> selectAll();
    Map<String, Object> deleteById(Integer id);
    Map<String, Object> insert(Sysinfo_t sysinfo_t);
    Map<String, Object> updateById(Integer id);
    Map<String, Object> selectById(Integer id);
    Map<String, Object> countById();
    public Map<String, Object> selectAllTimestamp();

    Map<String, Object> selectForCount(String hostname,String ip, String id);
    Map<String, Object> selectForPage(int index, String hostname,String ip, String id);
}
