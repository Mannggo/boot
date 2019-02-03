package com.zhongd.bootshiroweb.web.controller;

import com.zhongd.bootshiroweb.constant.AuthConstants;
import com.zhongd.bootshiroweb.dto.UserLoginDetails;
import constants.ResultCode;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

/**
 * 授权相关
 */
@Api("用户认证相关")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/nologin")
    @ApiOperation(value = "登录超时转发接口")
    public Result nologin() {
        Result result = new Result();
        result.setCode(ResultCode.LOGIN_ERROR.getCode());
        result.setMsg(ResultCode.LOGIN_ERROR.getDefaultMsg());
        return result;
    }

    @GetMapping("/unauthorized")
    @ApiOperation(value = "无权限转发接口")
    public Result unauthorized() {
        Result result = new Result();
        result.setCode(ResultCode.AUTH_ERROR.getCode());
        result.setMsg(ResultCode.AUTH_ERROR.getDefaultMsg());
        return result;
    }

    @PostMapping("/login")
    @ApiOperation("登录方法")
    public Result login(@RequestBody UserLoginDetails details) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(details.getUsername(), details.getPassword()));
            subject.getSession().setAttribute(AuthConstants.CURRENT_USER_KEY, subject.getPrincipal());
            return Result.success();
        } catch (AuthenticationException e) {
            return Result.serviceError("登录失败: " + e.getMessage());
        } catch (Exception e) {
            return Result.serviceError();
        }
    }
}
