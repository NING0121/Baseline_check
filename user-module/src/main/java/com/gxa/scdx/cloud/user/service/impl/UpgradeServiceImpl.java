package com.gxa.scdx.cloud.user.service.impl;

import com.gxa.scdx.cloud.user.mapper.UpgradeMapper;
import com.gxa.scdx.cloud.user.pojo.Upgrade;
import com.gxa.scdx.cloud.user.service.UpgradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * (upgrade)表服务实现类
 *
 * @author 林佳评
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */
@Service("upgradeService")
public class UpgradeServiceImpl implements UpgradeService {
    @Resource
    private UpgradeMapper upgradeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    @Override
    public Upgrade queryById(String username) {
        return this.upgradeMapper.queryById(username);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Upgrade> queryAllByLimit(int offset, int limit) {
        return this.upgradeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 查询所有数据
     * @return  返回所有数据
     */
    public Map<String, Object> selectAll(Upgrade upgrade) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0); //layui规定code值为0时才表示渲染成功
        map.put("msg", "查询成功");
        map.put("data", this.upgradeMapper.queryAll(upgrade));
        return map;
    }

    /**
     * 新增数据
     *
     * @param upgrade 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(Upgrade upgrade) {
        Map<String, Object> map = new HashMap<>();
        try{
            this.upgradeMapper.insert(upgrade);
            map.put("code", 200);
            map.put("msg", "申请成功");
        }catch (Exception e){
            map.put("code", 500);
            map.put("msg", e);
        }
        return map;
    }

    /**
     * 修改数据
     *
     * @param upgrade 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(Upgrade upgrade) {
        Map<String, Object> map = new HashMap<>();
        try{
            this.upgradeMapper.update(upgrade);
            map.put("code", 200);
            map.put("msg", "操作成功");
        }catch (Exception e){
            map.put("code", 500);
            map.put("msg", "操作失败");
        }
        return map;
    }

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String username) {
        return this.upgradeMapper.deleteById(username) > 0;
    }
}