package com.zhongd.bootapi.interceptor.validator;

import com.zhongd.bootapi.interceptor.validator.dto.ValidateParam;

/**
 * 接口调用频率校验
 * @author 谢仲东 2018-12-05 11:34
 */
public class FrequencyValidator implements Validator {
    @Override
    public boolean validate(ValidateParam param) {
        return true;
    }
}
