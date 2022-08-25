package com.gxa.scdx.cloud.user.controller;

import com.gxa.scdx.cloud.user.pojo.Department;
import com.gxa.scdx.cloud.user.service.impl.DepartmentServiceImpl;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Department)表控制层
 *
 * @author 代宇盛 easycode生成全部，部分有修改
 * @author 王楠楠 修改 selectForpage/count 实现模糊查询
 * @version 1.0
 * @since 2021-06-25 11:06:05
 */

@RestController
@RequestMapping("/department")
@Api(value = "(Department)管理", tags = "(Department)管理接口API")
@ApiResponses({
        @ApiResponse(code = 400, message = "请求参数不完整或者错误"),
        @ApiResponse(code = 404, message = "找不到页面"),
        @ApiResponse(code = 405, message = "请求方式不正确，比如后台接收是post，但前端请求的是get"),
        @ApiResponse(code = 406, message = "页面地址和接口名冲突"),
        @ApiResponse(code = 415, message = "请求格式不正确，前端可能没有把请求头修改为json，也可能前端请求的json对象没有转换为字符串"),
        @ApiResponse(code = 500, message = "后台服务逻辑错误")
})
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentServiceImpl departmentServiceImpl;


    /**
     * 通过主键查询单条数据
     *
     * @param index 需要查询的页码
     * @param departmentNumber,departmentName  模糊查询的内容
     * @return 单条数据
     */
    @RequestMapping(value = "/selectForPage", method = RequestMethod.GET)
    @ApiOperation(value = "列表查询分页接口", notes = "列表查询分页接口", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "departmentNumber", value = "部门编号", paramType = "query", dataType = "String", required = false),
            @ApiImplicitParam(name = "departmentName", value = "部门名称", paramType = "query", dataType = "String", required = false)
    })
    public Map<String, Object> selectForPage(@RequestParam(name = "page") int index, String departmentNumber, String departmentName) {

        return this.departmentServiceImpl.selectForPage(index, departmentNumber, departmentName);
    }


    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有数据接口", notes = "查询所有数据接口", httpMethod = "GET")
    public Map<String, Object> selectAll() {
        return this.departmentServiceImpl.selectAll();
    }

    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    @ApiOperation(value = "根据一个主键删除一条**记录的接口", notes = "根据一个主键删除一条**记录的接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query", dataType = "String", required = true),
    })
    public Map<String, Object> deleteById(@RequestParam("id") String id) {
        return this.departmentServiceImpl.deleteById(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @ApiOperation(value = "通过主键查询一个department的接口", notes = "通过主键查询一个department的接口", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query", dataType = "Integer", required = true),
    })
    public Map<String, Object> selectById(Integer id) {
        return this.departmentServiceImpl.selectById(id);
    }

    /**
     * 通过主键更新单条数据
     *
     * @param department 一个数据库对应的POJO数据对象
     * @return 单条数据
     */
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ApiOperation(value = "通过主键更新一个department的接口", notes = "通过主键更新一个department的接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "department", value = "pojo模型", paramType = "query", dataType = "department", required = true),
    })
    public Map<String, Object> updateById(@RequestBody @ApiParam(name = "department", value = "pojo模型", required = true) Department department) {
        return this.departmentServiceImpl.updateById(department);
    }

    /**
     * 通过一个pojo对象新增单条数据
     *
     * @param department 一个数据库对应的POJO数据对象
     * @return 返回插入的主键id
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "根据完整记录新增一个department的接口", notes = "根据完整记录新增一个department的接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "department", value = "pojo模型", paramType = "query", dataType = "department", required = true),
    })
    public Map<String, Object> insert(@RequestBody @ApiParam(name = "department", value = "pojo模型", required = true) Department department) {
        return this.departmentServiceImpl.insert(department);
    }


    /**
     * 通过department_name查询单条数据
     *
     * @param department_name 主键
     * @return 实例对象
     */
    @RequestMapping(value = "/selectByName", method = RequestMethod.POST)
    @ApiOperation(value = "根据完整记录新增一个department的接口", notes = "根据完整记录新增一个department的接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "department_name", value = "部门名", paramType = "query", dataType = "String", required = true),
    })
    public Map<String, Object> selectByName(@RequestBody @ApiParam(name = "department_name", value = "department_name", required = true) String  department_name) {
        return this.departmentServiceImpl.selectByName(department_name);
    }
}
