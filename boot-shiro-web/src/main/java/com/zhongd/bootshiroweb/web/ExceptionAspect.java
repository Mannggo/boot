package com.zhongd.bootshiroweb.web;

import constants.ResultCode;
import entity.Result;
import exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 谢仲东
 * @description
 * @since 15:45 星期日 2019/2/3
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class ExceptionAspect {

    @Around("execution(* com.zhongd.bootshiroweb.web.controller..*.*(..))")
    public Object handle(ProceedingJoinPoint pj) {
        try {
            return pj.proceed();
        } catch (AuthorizationException e) {
            log.warn("权限不足 => 参数：{}", argsToString(pj.getArgs()));
            Result result = new Result();
            result.setCode(ResultCode.AUTH_ERROR.getCode());
            result.setMsg(ResultCode.AUTH_ERROR.getDefaultMsg());
            return result;
        } catch (ServiceException e) {
            log.warn("业务异常 => 参数：{}", argsToString(pj.getArgs()));
            return Result.serviceError(e.getMessage());
        }catch (Throwable e) {
            log.error("系统异常 => 参数：{}", argsToString(pj.getArgs()));
            log.error(e.getMessage(), e);
            return Result.systemError();
        }
    }

    private String argsToString(Object[] args) {
        if (args == null || args.length == 0) {
            return "无";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object o: args) {
                sb.append(o.toString()).append("\n");
            }
            return sb.toString();
        }
    }
}
