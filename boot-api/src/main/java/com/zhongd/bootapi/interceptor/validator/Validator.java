package com.zhongd.bootapi.interceptor.validator;

import com.zhongd.bootapi.interceptor.validator.dto.ValidateParam;

/**
 * @author 谢仲东 2018-12-05 10:07
 */
public interface Validator {

    boolean validate(ValidateParam param);

}
