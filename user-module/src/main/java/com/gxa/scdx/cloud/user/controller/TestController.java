package com.gxa.scdx.cloud.user.controller;


import com.gxa.scdx.cloud.user.service.impl.ProcessDataServiceImpl;
import com.gxa.scdx.cloud.user.socket.Server;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * (Socket) 控制层
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:50
 */

@RestController
@Api(value = "Socket接口测试",tags = "Socket接口测试API")
@ApiResponses({
        @ApiResponse(code=400,message="请求参数不完整或者错误"),
        @ApiResponse(code=404,message="找不到页面"),
        @ApiResponse(code=405,message="请求方式不正确，比如后台接收是post，但前端请求的是get"),
        @ApiResponse(code=406,message="页面地址和接口名冲突"),
        @ApiResponse(code=415,message="请求格式不正确，前端可能没有把请求头修改为json，也可能前端请求的json对象没有转换为字符串"),
        @ApiResponse(code=500,message="后台服务逻辑错误")
})
public class TestController {

    @Resource
    private ProcessDataServiceImpl processDataService;

    @GetMapping("/openSockets")
    @ApiOperation(value = "Socket接口测试",notes = "Socket接口测试",httpMethod = "GET")
    public String openSocket() throws Exception {
        System.out.println("---------TestController---------");
        Server server = new Server(processDataService);
//        Sysinfo_t sysinfo_t = new Sysinfo_t();
//        sysinfo_t.setTotalMem("1111");
//        processDataService.insertTest(sysinfo_t);


        return "success";
    }
}
