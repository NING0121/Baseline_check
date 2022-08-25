package com.gxa.scdx.cloud.user.service.impl;

import com.gxa.scdx.cloud.user.pojo.Baselineinfo;
import com.gxa.scdx.cloud.user.mapper.BaselineinfoMapper;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (baselineinfo)表服务实现类
 *
 * @author 王研博 easycode生成
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:21
 */

@Service("baselineinfoService")
public class BaselineinfoServiceImpl {
    @Resource
    private BaselineinfoMapper baselineinfoMapper;



    /**
     * 根据模糊条件查询总个数
     *
     * @param search_id,search_id,search_result 查询条件
     * @return 返回查询到的总个数
     */
    public Map<String, Object> selectForCount(String search_id, String search_name, String search_result) {
        Map<String, Object> map = new HashMap<>();
        // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("list", this.baselineinfoMapper.selectForCount(search_id, search_name, search_result));
        System.out.println(map);
        return map;
    }

    /**
     * 根据模糊条件查询个数
     *
     * @return 返回查询到的个数
     */
    public Map<String, Integer> selectForShow() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int resultAll = this.baselineinfoMapper.selectForCount(null, null,null);
        int resultTrue = this.baselineinfoMapper.selectForShow();
        System.out.println(resultAll);
        map.put("resultAll",resultAll);
        map.put("resultTrue", resultTrue);
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
        map.put("list", this.baselineinfoMapper.selectAll());
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
        map.put("obj", this.baselineinfoMapper.selectById(id));
        return map;
    }

    /**
     * 查询分页数据
     *
     * @param index 查询起始位置
     * @param search_id,search_name,search_result  查询条件
     * @return 对象列表
     */
    public Map<String, Object> selectForPage(int index, String search_id , String search_name, String search_result) {
        // 获取当前表中的总记录
        int tableCount = this.baselineinfoMapper.selectForCount(search_id, search_name, search_result);
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
        map.put("data", this.baselineinfoMapper.selectForPage(index, search_id, search_name, search_result));
        return map;
    }

    /**
     * 新增数据
     *
     * @param baselineinfo 实例对象
     * @return 实例对象
     */
    public Map<String, Object> insert(Baselineinfo baselineinfo) {
        // UUID.randomUUID()  返回内容：asd21321-ewrewrew213213-123213zsad-123asdasd这样的形态
        this.baselineinfoMapper.insert(baselineinfo);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "新增成功");
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param baselineinfo 实例对象
     * @return 实例对象
     */
    public Map<String, Object> updateById(Baselineinfo baselineinfo) {
        this.baselineinfoMapper.updateById(baselineinfo);
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
        this.baselineinfoMapper.deleteById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);   // 前端端分离时，前端人员会首先判断code值是否满足200，如果不是200，则提醒用户失败
        map.put("msg", "删除成功");
        return map;
    }

    public Map<String, Object> countById(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", this.baselineinfoMapper.countById());
        return map;
    };
}
