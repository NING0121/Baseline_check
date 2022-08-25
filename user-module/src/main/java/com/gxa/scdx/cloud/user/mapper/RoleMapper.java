package com.gxa.scdx.cloud.user.mapper;

import com.gxa.scdx.cloud.user.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (Admin)表数据库访问层
 *
 * @author 代宇盛 easycode生成全部
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */
public interface RoleMapper {

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    List<Role> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role selectById(@Param("id") Integer id);

    /**
     * 根据模糊条件查询总个数
     *
     * @return 返回查询到的总个数
     */
    int selectForCount(String name);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param index 查询起始位置
     * @param name  查询条件
     * @return 对象列表
     */
    List<Role> selectForPage(@Param("index") int index, @Param("name") String name);

    /**
     * 新增数据
     *
     * @param role 实例对象
     */
    void insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int updateById(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") String id);

}
