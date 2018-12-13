package com.zhongd.bootapi.web.aspect.signature;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author 谢仲东
 * @description 标记需要签名的方法
 * @since 22:34 星期四 2018/12/13
 */
@Target(ElementType.METHOD)
public @interface SignRequest {
}
