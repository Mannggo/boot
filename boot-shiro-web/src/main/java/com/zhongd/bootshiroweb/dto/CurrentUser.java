package com.zhongd.bootshiroweb.dto;

import com.zhongd.bootshiroweb.entity.Resource;
import com.zhongd.bootshiroweb.entity.Role;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author 谢仲东
 * @description
 * @since 14:38 星期日 2019/2/3
 */
@Data
public class CurrentUser {

    private Integer userId;
    private String username;
    private String password;

    private Set<Role> roles;
    private Set<Resource> resources;

    public void addResource(Set<Resource> resources) {
        if (this.resources == null) {
            this.resources = resources;
        } else {
            this.resources.addAll(resources);
        }
    }
}
