package com.gxa.scdx.cloud.user.mapper;

import com.gxa.scdx.cloud.user.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author 代宇盛 easycode生成全部
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

public interface AdminMapper {


    Admin getUser(@Param("username") String username);

    void registerUser(@Param("username") String username, @Param("password") String password
            , @Param("createTime") Timestamp createTime, @Param("phone") String phone);
    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    List<Admin> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin selectById(@Param("id") Integer id);

    /**
     * 根据模糊条件查询总个数
     *
     * @return 返回查询到的总个数
     */
    int selectForCount(@Param("search_username") String search_username,
                       @Param("search_phone") String search_phone,
                       @Param("search_start_time") String search_start_time,
                       @Param("search_end_time") String search_end_time);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param index 查询起始位置
     * @return 对象列表
     */
    List<Admin> selectForPage(@Param("index") int index,
                              @Param("search_username") String search_username,
                              @Param("search_phone") String search_phone,
                              @Param("search_start_time") String search_start_time,
                              @Param("search_end_time") String search_end_time);


    /**
     * 新增数据
     *
     * @param admin 实例对象
     */
    void insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int updateById(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 用户名称
     * @return 影响行数
     */
    int updateByName(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") Integer id);

}
