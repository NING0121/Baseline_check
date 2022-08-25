package com.gxa.scdx.cloud.user.controller;

import com.gxa.scdx.cloud.user.service.RedisService;
import io.swagger.annotations.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (redis)控制层
 *
 * @author 代宇盛 easycode生成全部，部分有修改
 * @author 林佳评 增加getAdminNum方法（用于统计管理员信息，渲染index页面）
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */

@Api(value = "(Redis)管理", tags = "(Redis)管理接口API")
@ApiResponses({
        @ApiResponse(code = 400, message = "请求参数不完整或者错误"),
        @ApiResponse(code = 404, message = "找不到页面"),
        @ApiResponse(code = 405, message = "请求方式不正确，比如后台接收是post，但前端请求的是get"),
        @ApiResponse(code = 406, message = "页面地址和接口名冲突"),
        @ApiResponse(code = 415, message = "请求格式不正确，前端可能没有把请求头修改为json，也可能前端请求的json对象没有转换为字符串"),
        @ApiResponse(code = 500, message = "后台服务逻辑错误")
})
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisService redisService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @ApiOperation(value = "得到管理员数量接口", notes = "取得管理员数量", httpMethod = "GET")
    @ApiImplicitParams({
    })
    @GetMapping("/getAdminNum")
    public Map<String, Object> getAdminNum() {
        return redisService.getAdminNum();
    }






}
