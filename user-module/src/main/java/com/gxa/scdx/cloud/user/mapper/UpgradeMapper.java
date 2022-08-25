package com.gxa.scdx.cloud.user.mapper;

import com.gxa.scdx.cloud.user.pojo.Upgrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 ** (Upgrade)表数据库访问层
 *
 * @author 林佳评
 * @version 1.0
 * @since 2021-06-25 11:06:39
 */
public interface UpgradeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    Upgrade queryById(String username);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Upgrade> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Upgrade> queryAll(Upgrade upgrade);

    /**
     * 新增数据
     *
     * @param upgrade 实例对象
     * @return 影响行数
     */
    int insert(Upgrade upgrade);

    /**
     * 修改数据
     *
     * @param upgrade 实例对象
     * @return 影响行数
     */
    int update(Upgrade upgrade);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 影响行数
     */
    int deleteById(String username);
}
