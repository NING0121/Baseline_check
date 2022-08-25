
package com.gxa.scdx.cloud.user.service;
/**
 * (ProcessData) 服务接口类
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:02
 */
public interface ProcessDataService {
    void process(Integer option, String msg, Integer deviceid);
}
