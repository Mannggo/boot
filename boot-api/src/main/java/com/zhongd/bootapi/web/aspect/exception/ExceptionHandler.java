package com.zhongd.bootapi.web.aspect.exception;

import exception.ParamException;
import exception.SignException;
import entity.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 谢仲东
 * @description web层异常统一处理
 * @since 23:09 星期四 2018/12/13
 */
@ControllerAdvice
@Order(3)
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse systemException(Exception e) {
        return BaseResponse.systemError();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SignException.class)
    @ResponseBody
    public BaseResponse signException(SignException e) {
        return BaseResponse.fail(e.getMsg(), e.getCode());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ParamException.class)
    @ResponseBody
    public BaseResponse paramException(ParamException e) {
        return BaseResponse.fail(e.getMsg(), e.getCode());
    }

}
