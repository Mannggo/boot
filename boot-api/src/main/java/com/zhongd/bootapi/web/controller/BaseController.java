package com.zhongd.bootapi.web.controller;

import exception.ParamException;
import org.springframework.validation.BindingResult;
import constants.ExceptionMsg;

/**
 * @author 架构师谢仲东
 * @description 包含公共方法的父类
 * @since 21:37 星期四 2018/12/13
 */
public final class BaseController {

    /**
     * RequestBody 参数校验
     * @param result
     */
    protected void validateParam(BindingResult result) {
        if (result.hasErrors()) {
            throw new ParamException(result.getFieldError().getDefaultMessage(),
                    ExceptionMsg.PARAM_ERROR.getCode());
        }
    }
}
