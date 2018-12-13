package com.zhongd.bootapi.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Random;

/**
 * @author 谢仲东 2018-12-05 15:05
 */
@Aspect
@Component
@Slf4j
public class SignAspect {

    @Pointcut(value = "execution(public * com.zhongd.bootapi.controller.*.*(..))")
    public void getParam(){}

//    @Around("getParam()")
    public void doBefore(ProceedingJoinPoint point) throws Throwable {
        for (Object obj :  point.getArgs()) {
            log.info("data ===>>> {}, type ===>>> {}", obj.toString(), obj.getClass().getName());
        }
        HashMap<String, Object> param = new HashMap<>();
        param.put("text", "12388+++");
        param.put("sign", "668qq+++");
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        if (new Random().nextBoolean()) {
            param.clear();
            param.put("abc", "???");
            response.getWriter().write(param.toString());
            return;
        }
        Object a = point.proceed(new Object[]{param});
        log.info("result ===>>> {}, {}", a, a.getClass().getName());
        log.info("request ===>>> end");

    }
}
