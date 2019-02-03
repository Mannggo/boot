package com.zhongd.bootshiroweb.config.shiro;


import com.zhongd.bootshiroweb.constant.AuthConstants;
import com.zhongd.bootshiroweb.dto.CurrentUser;
import com.zhongd.bootshiroweb.entity.Resource;
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
import util.CommonConverterTools;

import java.util.List;
import java.util.Set;

public class WebRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        CurrentUser currentUser = (CurrentUser) SecurityUtils.getSubject().getSession().getAttribute(AuthConstants.CURRENT_USER_KEY);
        Set<Role> roles = userService.listUserRoles(currentUser.getUserId());
        currentUser.setRoles(roles);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        roles.forEach(r -> {
            info.addRole(r.getValue());
            Set<Resource> resources = userService.listRoleResource(r.getRoleId());
            currentUser.addResource(resources);
            resources.forEach(rs -> {
                info.addStringPermission(rs.getValue());
            });
        });
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getByUsername(token.getUsername());
        CurrentUser currentUser = CommonConverterTools.convert(CurrentUser.class, user);
        if (currentUser == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(currentUser, currentUser.getPassword(), "");
    }
}
