package com.zhongd.bootshiroweb.service;

import com.zhongd.bootshiroweb.entity.Resource;
import com.zhongd.bootshiroweb.entity.Role;
import com.zhongd.bootshiroweb.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @author 谢仲东 2019/2/1 14:21
 */
public interface UserService {

    User getByUsername(String username);

    Set<Role> listUserRoles(Integer userId);

    Set<Resource> listRoleResource(Integer roleId);
}
