
package com.gxa.scdx.cloud.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author 王研博
 *
 */
@Mapper
public interface ScanMapper {
    int selectByDeviceId(@Param("id")Integer id);
    void updateByDeviceId(@Param("id")Integer id, @Param("val")Integer value);
}
