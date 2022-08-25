package com.gxa.scdx.cloud.user.service.impl;

import com.gxa.scdx.cloud.user.pojo.Patchinfo;
import com.gxa.scdx.cloud.user.mapper.PatchinfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (patchinfo)表服务实现类
 *
 * @author 王研博 easycode生成
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */

@Service("patchinfoService")
public class PatchinfoServiceImpl {
    @Resource
    private PatchinfoMapper patchinfoMapper;

    /**
     * 根据模糊条件查询总个数
     *
     * @param name 查询条件
     * @return 返回查询到的总个数
     */
    public Map<String, Object> selectForCount(String search_id, String search_number, String search_start_time, String search_end_time) {
        Map<String, Object> map = new HashMap<>();
        // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("list", this.patchinfoMapper.selectForCount(search_id, search_number, search_start_time, search_end_time));
        return map;
    }

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    public Map<String, Object> selectAll() {
        Map<String, Object> map = new HashMap<>();
        // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("list", this.patchinfoMapper.selectAll());
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Map<String, Object> selectById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("obj", this.patchinfoMapper.selectById(id));
        return map;
    }

    /**
     * 查询分页数据
     *
     * @param index 查询起始位置
     * @param search_id,search_number,search_start_time,search_end_time  查询条件
     * @return 对象列表
     */
    public Map<String, Object> selectForPage(int index, String search_id, String search_number, String search_start_time, String search_end_time) {
        // 获取当前表中的总记录
        int tableCount = this.patchinfoMapper.selectForCount(search_id, search_number, search_start_time, search_end_time);
        // 总页码计算   (总条数 - 1) / 每页显示条数  + 1
        // (100 - 1) / 10 + 1 = 10        (101 - 1) / 10 + 1 = 11      (99 - 1) / 10 + 1 = 10
        int pageCount = (tableCount - 1) / 10 + 1;
        // 计算每页开始的下标值
        index = (index - 1) * 10;
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "查询成功");
        map.put("pageCount", pageCount);  // 查询的记录总页码
        map.put("count", tableCount);     // 当前表中的总条数
        map.put("data", this.patchinfoMapper.selectForPage(index, search_id, search_number, search_start_time, search_end_time));
        System.out.println(map);
        return map;
    }

    /**
     * 新增数据
     *
     * @param patchinfo 实例对象
     * @return 实例对象
     */
    public Map<String, Object> insert(Patchinfo patchinfo) {
        // UUID.randomUUID()  返回内容：asd21321-ewrewrew213213-123213zsad-123asdasd这样的形态
        this.patchinfoMapper.insert(patchinfo);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "新增成功");
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param patchinfo 实例对象
     * @return 实例对象
     */
    public Map<String, Object> updateById(Patchinfo patchinfo) {
        this.patchinfoMapper.updateById(patchinfo);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "更新成功");
        return map;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public Map<String, Object> deleteById(String id) {
        this.patchinfoMapper.deleteById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "删除成功");
        return map;
    }

    public Map<String, Object> countById(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", this.patchinfoMapper.countById());
        return map;
    };
}
