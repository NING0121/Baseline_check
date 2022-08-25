/**
 * @Author: 王研博
 *
 */
package com.gxa.scdx.cloud.user.controller;
import io.swagger.annotations.*;
import com.gxa.scdx.cloud.user.dto.ResultDTO;
import com.gxa.scdx.cloud.user.service.impl.ScanServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
/**
 * (scan) 控制层
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:50
 */
@RestController
@RequestMapping("/scan")
public class ScanController {
    @RequestMapping("/testPathVariable/{id}/{value}")
    @ApiOperation(value = "查询设备是否上线接口", notes = "查询设备是否上线", httpMethod = "GET")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "testPathVariable", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "value", value = "testPathVariable", paramType = "query", dataType = "Integer", required = true)
    })
    public String testPathVariable(@PathVariable("id") Integer id,@PathVariable("value") Integer value)
    {
        System.out.println("testPathVariable:"+id);
        System.out.println("testPathVariable:"+value);
        return "success";}

    @Resource
    private ScanServiceImpl scanservice;


    @GetMapping("/device/{id}")
    @ApiOperation(value = "设备查询接口", notes = "设备查询接口", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "DeviceId", paramType = "query", dataType = "Integer", required = true),
    })
    public Map<String, Object> selectByDeviceId(@PathVariable("id") Integer id) {
        return this.scanservice.selectByDeviceId(id);
    }

    @GetMapping("/update/{id}/{value}")
    @ApiOperation(value = "设备更新接口", notes = "通过设备号进行更新", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "DeviceId", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "value", value = "更新的参数", paramType = "query", dataType = "Integer", required = true)
    })
    public Map<String, Object> updateByDeviceId(@PathVariable("id") Integer id,@PathVariable("value") Integer value) {
        return this.scanservice.updateByDeviceId(id,value);
    }


}
