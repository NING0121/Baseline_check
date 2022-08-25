package com.gxa.scdx.cloud.user.service;

import com.gxa.scdx.cloud.user.pojo.Department;

import java.util.Map;

/**
 * (Department)表服务接口类
 *
 * @author 代宇盛
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:02
 */
public interface DepartmentService {
    /**
     * 根据模糊条件查询总个数
     *
     * @param name 查询条件
     * @return 返回查询到的总个数
     */
    Map<String, Object> selectForCount(String name);

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    Map<String, Object> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> deleteById(Integer id);

    /**
     * 查询分页数据
     *
     * @param index 查询起始位置
     * @param name  查询条件
     * @return 对象列表
     */
    Map<String, Object> selectForPage(int index, String name);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(Department department);

    /**
     * 通过ID查询单条数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateById(Department department);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Map<String, Object> deleteById(String id);


    Map <String, Object> selectByName(String department);
}
