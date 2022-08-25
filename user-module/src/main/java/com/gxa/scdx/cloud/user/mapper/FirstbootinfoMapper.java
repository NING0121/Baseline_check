package com.gxa.scdx.cloud.user.mapper;

import com.gxa.scdx.cloud.user.pojo.Firstbootinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Firstbootinfo)表数据库访问层
 *
 * @author 王研博
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:25
 */
public interface FirstbootinfoMapper {

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    List<Firstbootinfo> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Firstbootinfo selectById(@Param("id") Integer id);

    /**
     * 根据模糊条件查询总个数
     *
     * @return 返回查询到的总个数
     */
    int selectForCount(String search_id, String search_name, String search_path);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param index 查询起始位置
     * @param search_id,search_name,search_path  查询条件
     * @return 对象列表
     */
    List<Firstbootinfo> selectForPage(@Param("index") int index,
                                      @Param("search_id") String search_id,
                                      @Param("search_name") String search_name,
                                      @Param("search_path")String search_path);

    /**
     * 新增数据
     *
     * @param firstbootinfo 实例对象
     */
    void insert(Firstbootinfo firstbootinfo);

    /**
     * 修改数据
     *
     * @param firstbootinfo 实例对象
     * @return 影响行数
     */
    int updateById(Firstbootinfo firstbootinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") String id);
    int countById();
}
