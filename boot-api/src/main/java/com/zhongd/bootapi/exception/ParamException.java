package com.zhongd.bootapi.exception;

import lombok.Getter;

/**
 * @author 谢仲东
 * @description 参数异常
 * @since 21:05 星期四 2018/12/13
 */
@Getter
public class ParamException extends RuntimeException{
    private String msg;
    private String code;

    public ParamException(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }
}
