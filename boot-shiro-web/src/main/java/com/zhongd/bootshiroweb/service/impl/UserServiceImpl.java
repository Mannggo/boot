package com.zhongd.bootshiroweb.service.impl;

import com.zhongd.bootshiroweb.dao.UserMapper;
import com.zhongd.bootshiroweb.entity.Role;
import com.zhongd.bootshiroweb.entity.User;
import com.zhongd.bootshiroweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谢仲东 2019/2/1 14:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public List<Role> listUserRoles(Integer userId) {
        return userMapper.listUserRoles(userId);
    }
}
