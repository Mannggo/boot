package com.zhongd.bootshiroweb.dao;

import com.zhongd.bootshiroweb.entity.Role;
import com.zhongd.bootshiroweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 谢仲东 2019/2/1 14:33
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User getByUsername(String username);

    @Select("select * from role a join user_role b on a.role_id = b.role_id where b.user_id = #{userId}")
    List<Role> listUserRoles(Integer userId);
}
