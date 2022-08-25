package com.gxa.scdx.cloud.user.mapper;

import com.gxa.scdx.cloud.user.pojo.Serviceinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Serviceinfo)表数据库访问层
 *
 * @author 王研博
 * @author 林佳评 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:52
 */
public interface ServiceinfoMapper {

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    List<Serviceinfo> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Serviceinfo selectById(@Param("id") Integer id);

    /**
     * 根据模糊条件查询总个数
     *
     * @return 返回查询到的总个数
     */
    int selectForCount(String name, String state, @Param("deviceId") String deviceId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param index 查询起始位置
     * @param name  查询条件
     * @return 对象列表
     */
    List<Serviceinfo> selectForPage(@Param("index") int index, @Param("name") String name, @Param("state") String state, @Param("deviceId") String deviceId);

    /**
     * 新增数据
     *
     * @param serviceinfo 实例对象
     */
    void insert(Serviceinfo serviceinfo);

    /**
     * 修改数据
     *
     * @param serviceinfo 实例对象
     * @return 影响行数
     */
    int updateById(Serviceinfo serviceinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") String id);
    int countById();

}
