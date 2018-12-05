package com.zhongd.bootapi.interceptor.validator.dto;

import lombok.Data;

/**
 * @author 谢仲东 2018-12-05 11:14
 */
@Data
public class ValidateParam {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

}
