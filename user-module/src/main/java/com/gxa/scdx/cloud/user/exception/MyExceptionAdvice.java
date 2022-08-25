package com.gxa.scdx.cloud.user.exception;


/**
 * (ResultDTO) dto对象
 *
 * @author all;
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */

import com.gxa.scdx.cloud.user.dto.ResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionAdvice {


    /**
     * 这个方法专门用于处理登录异常
     * @param e
     * @return
     */
    @ExceptionHandler(LoginExcetion.class)
    public ResultDTO loginExceptionHandler(LoginExcetion e){

        // 记录登录错误日志

        return new ResultDTO(e.getCode(), e.getMsg());
    }


//    @ExceptionHandler(Exception.class)
//    public ResultDTO  exceptionHandler(Exception e){
//        // 记录的异常日志
//        // 异常日志对于一个系统来说， 很重要。
//
//        return new ResultDTO(1002, e.getMessage());
//    }



}
