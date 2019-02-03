package com.zhongd.bootshiroweb.web.controller;

import entity.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢仲东 2019/2/1 16:00
 */
@RestController
@RequestMapping("/test")
@Slf4j
@Api("测试接口")
public class TestController extends BaseController{

    @GetMapping("/list")
    public Result list() {
        log.info("当前用户 => {}", currentUser());
        return Result.success("成功！");
    }

    @GetMapping("/user/del")
    @RequiresPermissions("user:del")
    public Result userDel() {
        log.info("测试权限 /user/del");
        return Result.success();
    }

    @GetMapping("/user/add")
    @RequiresPermissions("user:add")
    public Result userAdd() {
        log.info("测试权限 /user/add");
        return Result.success();
    }

}
