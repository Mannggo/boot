package com.zhongd.bootshiroweb.service;

import com.zhongd.bootshiroweb.entity.Role;
import com.zhongd.bootshiroweb.entity.User;

import java.util.List;

/**
 * @author 谢仲东 2019/2/1 14:21
 */
public interface UserService {

    User getByUsername(String username);

    List<Role> listUserRoles(Integer userId);
}
