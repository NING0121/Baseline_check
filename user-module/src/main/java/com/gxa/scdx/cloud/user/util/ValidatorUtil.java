package com.gxa.scdx.cloud.user.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author all;
 */
public class ValidatorUtil {

    /**
     * 展示错误信息
     * @param bindingResult
     */
    public static void showMsg(BindingResult bindingResult) throws Exception {
        // 获取所有的错误
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            throw new Exception(error.getDefaultMessage());
        }
    }

}
