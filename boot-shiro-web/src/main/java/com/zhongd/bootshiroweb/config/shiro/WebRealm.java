package com.zhongd.bootshiroweb.config.shiro;


import com.zhongd.bootshiroweb.entity.Role;
import com.zhongd.bootshiroweb.entity.User;
import com.zhongd.bootshiroweb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WebRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        List<Role> roles = userService.listUserRoles(user.getUserId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        roles.forEach(r -> {
            info.addRole(r.getValue());
        });
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getByUsername(token.getUsername());
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
