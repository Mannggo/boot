package com.zhongd.bootshiroweb.service;

import com.zhongd.bootshiroweb.BootShiroWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢仲东 2019/2/1 15:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootShiroWebApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        System.out.println(userService.getByUsername("admin"));
    }

    @Test
    public void testRoles() {
        System.out.println(userService.listUserRoles(userService.getByUsername("admin").getUserId()));
    }
}
