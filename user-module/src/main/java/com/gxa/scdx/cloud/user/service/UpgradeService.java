package com.gxa.scdx.cloud.user.service;

import com.gxa.scdx.cloud.user.pojo.Upgrade;

import java.util.List;
import java.util.Map;

/**
 * (Upgrade)表服务接口类
 *
 * @author 林佳评 easycode生成
 * @version 1.0
 * @since 2021-06-25 11:06:02
 */
public interface UpgradeService {

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    Upgrade queryById(String username);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Upgrade> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有数据
     *
     * @return  返回所有数据
     */
    Map<String, Object> selectAll(Upgrade upgrade);

    /**
     * 新增数据
     *
     * @param upgrade 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(Upgrade upgrade);

    /**
     * 修改数据
     *
     * @param upgrade 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(Upgrade upgrade);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    boolean deleteById(String username);

}