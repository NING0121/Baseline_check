/**
 * @Author: 王研博
 *
 */
package com.gxa.scdx.cloud.user.controller;

import com.gxa.scdx.cloud.user.pojo.Sysinfo_t;
import com.gxa.scdx.cloud.user.service.impl.SysinfoTServiceImpl;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

/**
 * (Serviceinfo)表控制层
 *
 * @author 王研博
 * @author 林佳评 增加selectForPage方法
 * @version 1.0
 * @since 2021-06-25 11:06:50
 */

@RestController
@RequestMapping("/sysinfo")
@Api(value = "系统信息检测结果表(Sysinfo_t)管理",tags = "系统信息检测结果表(Sysinfo_t)系统信息检测结果接口API")
@ApiResponses({
        @ApiResponse(code=400,message="请求参数不完整或者错误"),
        @ApiResponse(code=404,message="找不到页面"),
        @ApiResponse(code=405,message="请求方式不正确，比如后台接收是post，但前端请求的是get"),
        @ApiResponse(code=406,message="页面地址和接口名冲突"),
        @ApiResponse(code=415,message="请求格式不正确，前端可能没有把请求头修改为json，也可能前端请求的json对象没有转换为字符串"),
        @ApiResponse(code=500,message="后台服务逻辑错误")
})
public class SysinfoTController {
    @Resource
    private SysinfoTServiceImpl sysinfotservice;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有数据接口",notes = "查询所有数据接口",httpMethod = "GET")
    public Map<String, Object> selectAll() {
        return this.sysinfotservice.selectAll();
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    @ApiOperation(value = "根据一个主键删除一条系统信息检测结果记录的接口",notes = "根据一个主键删除一条系统信息检测结果记录的接口",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键",paramType = "query",dataType = "String",required = true),
    })
    public Map<String, Object> deleteById(@RequestParam("id") Integer id) {
        return this.sysinfotservice.deleteById(id);
    }

    @RequestMapping(value = "/countById", method = RequestMethod.GET)
    @ApiOperation(value = "统计当前表记录数量的接口",notes = "统计当前表记录数量的接口",httpMethod = "GET")
    public Map<String, Object> countById() {
        return this.sysinfotservice.countById();
    }

    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @ApiOperation(value = "通过主键查询单条数据接口",notes = "通过主键查询单条数据接口",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",paramType = "query",dataType = "Integer",required = true)
    })
    public Map<String, Object> selectById(Integer id) {
        return this.sysinfotservice.selectById(id);
    }

    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ApiOperation(value = "通过主键更新一条记录记录的接口",notes = "通过主键更新一条记录的接口",httpMethod = "POST")
    public Map<String, Object> updateById(@RequestBody @ApiParam(name = "id",value = "主键",required = true) Integer id) {
        return this.sysinfotservice.updateById(id);
    }

    @RequestMapping(value = "/selectAllTimestamp", method = RequestMethod.GET)
    @ApiOperation(value = "通过查询所有记录check_time字段接口",notes = "通过查询所有记录check_time字段接口",httpMethod = "GET")
    public Map<String, Object> selectAllTimestamp() {
        return this.sysinfotservice.selectAllTimestamp();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "根据完整记录新增一个插入记录的接口",notes = "根据完整记录新增一个插入记录的接口",httpMethod = "POST")
    public Map<String, Object> insert(@RequestBody @ApiParam(name = "sysinfo_t",value = "pojo模型",required = true) Sysinfo_t sysinfo_t) {
        return this.sysinfotservice.insert(sysinfo_t);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param index 需要查询的页码
     * @param hostname  模糊查询的内容
     * @return 单条数据
     */
    @RequestMapping(value = "/selectForPage", method = RequestMethod.GET)
    @ApiOperation(value = "列表查询分页接口", notes = "列表查询分页接口", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "hostname", value = "主机名称", paramType = "query", dataType = "String", required = false),
            @ApiImplicitParam(name = "ip", value = "ip", paramType = "query", dataType = "String", required = false),
            @ApiImplicitParam(name = "id", value = "设备id", paramType = "query", dataType = "String", required = false)
    })
    public Map<String, Object> selectForPage(@RequestParam(name = "page") int index, String hostname, String ip, String id) {
        return this.sysinfotservice.selectForPage(index, hostname, ip, id);
    }
}
