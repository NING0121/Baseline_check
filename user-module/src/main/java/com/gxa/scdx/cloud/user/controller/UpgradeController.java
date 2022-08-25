package com.gxa.scdx.cloud.user.controller;

import com.gxa.scdx.cloud.user.pojo.Admin;
import com.gxa.scdx.cloud.user.pojo.Upgrade;
import com.gxa.scdx.cloud.user.service.UpgradeService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Upgrade)表控制层
 *
 * @author 林佳评
 * @version 1.0
 * @since 2021-06-25 11:06:05
 */
@RestController
@RequestMapping("upgrade")
@Api(value = "权限提升表(Upgrade)管理",tags = "权限提升表(Upgrade)管理接口API")
@ApiResponses({
        @ApiResponse(code=400,message="请求参数不完整或者错误"),
        @ApiResponse(code=404,message="找不到页面"),
        @ApiResponse(code=405,message="请求方式不正确，比如后台接收是post，但前端请求的是get"),
        @ApiResponse(code=406,message="页面地址和接口名冲突"),
        @ApiResponse(code=415,message="请求格式不正确，前端可能没有把请求头修改为json，也可能前端请求的json对象没有转换为字符串"),
        @ApiResponse(code=500,message="后台服务逻辑错误")
})
public class UpgradeController {
    /**
     * 服务对象
     */
    @Resource
    private UpgradeService upgradeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation(value = "通过主键查询单条数据接口",notes = "通过主键查询单条数据接口",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",paramType = "query",dataType = "String",required = true)
    })
    public Upgrade selectOne(String id) {
        return this.upgradeService.queryById(id);
    }

    /**
     * 查询所有数据
     * @return 返回所有数据
     */
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有数据接口",notes = "查询所有数据接口",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "upgrade",value = "一个数据库对应的POJO数据对象",paramType = "query",dataType = "Upgrade",required = true)
    })
    public Map<String, Object> selectAll(Upgrade upgrade) {
        return this.upgradeService.selectAll(upgrade);
    }


    /**
     * 插入数据
     * @param upgrade 一个数据库对应的POJO数据对象
     * @return 单条数据
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "根据完整记录新增一个插入记录的接口",notes = "根据完整记录新增一个插入记录的接口",httpMethod = "POST")
    public Map<String, Object> insert(@RequestBody @ApiParam(name = "upgrade",value = "pojo模型",required = true) Upgrade upgrade) {
        return this.upgradeService.insert(upgrade);
    }


    /**
     * 更新数据
     *
     * @param upgrade 一个数据库对应的POJO数据对象
     * @return 单条数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "通过主键更新一条记录记录的接口",notes = "通过主键更新一条记录的接口",httpMethod = "POST")
    public Map<String, Object> updateById(@RequestBody @ApiParam(name = "upgrade",value = "pojo模型",required = true) Upgrade upgrade) {
        return this.upgradeService.update(upgrade);
    }

}