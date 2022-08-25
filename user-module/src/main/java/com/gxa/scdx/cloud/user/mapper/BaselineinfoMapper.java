package com.gxa.scdx.cloud.user.mapper;

import com.gxa.scdx.cloud.user.pojo.Baselineinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Baselineinfo)表数据库访问层
 *
 * @author 王研博
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

public interface BaselineinfoMapper {

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    List<Baselineinfo> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Baselineinfo selectById(@Param("id") Integer id);

    /**
     * 根据模糊条件查询总个数
     *
     * @return 返回查询到的总个数
     */
    int selectForCount(String search_id, String search_name, String search_result);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param index 查询起始位置
     * @param search_name,search_result  查询条件
     * @return 对象列表
     */
    List<Baselineinfo> selectForPage(@Param("index") int index,
                                     @Param("search_id")String search_id,
                                     @Param("search_name") String search_name,
                                     @Param("search_result") String search_result);

    /**
     * 新增数据
     *
     * @param baselineinfo 实例对象
     */
    void insert(Baselineinfo baselineinfo);

    /**
     * 修改数据
     *
     * @param baselineinfo 实例对象
     * @return 影响行数
     */
    int updateById(Baselineinfo baselineinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") String id);
    int countById();


    /**
     * 根据模糊条件查询总个数
     *
     * @return 返回查询到的总个数
     */
    int selectForShow();


}
