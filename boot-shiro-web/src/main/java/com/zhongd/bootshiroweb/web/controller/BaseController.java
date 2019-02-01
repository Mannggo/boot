package com.zhongd.bootshiroweb.web.controller;

import com.zhongd.bootshiroweb.constant.AuthConstants;
import com.zhongd.bootshiroweb.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author 谢仲东 2019/2/1 16:03
 */
public class BaseController {

    private Subject getSubject() {
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }

    public Session getSession() {
        return getSubject().getSession();
    }

    public User currentUser() {
        return (User) getSession().getAttribute(AuthConstants.CURRENT_USER_KEY);
    }
}
