package com.gxa.scdx.cloud.user.mapper;

import com.gxa.scdx.cloud.user.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (Department)表数据库访问层
 *
 * @author 代宇盛 easycode生成
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */


public interface DepartmentMapper {

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    List<Department> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Department selectById(@Param("id") Integer id);

    /**
     * 根据模糊条件查询总个数
     *
     * @return 返回查询到的总个数
     */
    int selectForCount(String departmentNumber, String departmentName);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param index 查询起始位置
     * @param departmentNumber,departmentName  查询条件
     * @return 对象列表
     */
    List<Department> selectForPage(@Param("index") int index,
                                   @Param("departmentNumber") String departmentNumber,
                                   @Param("departmentName") String departmentName);

    /**
     * 新增数据
     *
     * @param department 实例对象
     */
    void insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int updateById(Department department);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") String id);

    Department selectByName(@Param("department_name") String department_name);

}
