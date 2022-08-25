
package com.gxa.scdx.cloud.user.mapper;

import com.gxa.scdx.cloud.user.pojo.Serviceinfo;
import com.gxa.scdx.cloud.user.pojo.Sysinfo_t;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * (Sysinfo)表数据库访问层
 *
 * @author 王研博
 * @author 林佳评 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:39
 */
@Mapper
public interface SysinfoTMapper {
    List<Sysinfo_t> selectAll();


    Sysinfo_t selectById(@Param("id") Integer id);

    int countById();

    void insert(Sysinfo_t sysinfo_t);


    int updateById(Sysinfo_t sysinfo_t);


    int deleteById(@Param("id") Integer id);

    List<Timestamp> selectAllTimestamp();


    int selectForCount(@Param("hostname") String hostname, @Param("ip") String ip, @Param("id") String id);

    List<Serviceinfo> selectForPage(@Param("index") int index, @Param("hostname") String hostname, @Param("ip") String ip, @Param("id") String id);

}
