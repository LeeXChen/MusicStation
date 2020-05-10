package com.atmusic.test;

import com.atmusic.pojo.User;
import com.atmusic.service.UserService;
import com.atmusic.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LIXICHEN
 * @create 2020-04-20 20:31
 */
public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void regitUser() {
        userService.regitUser(new User(null,"abc168","666666","abc168@qq.com"));
        userService.regitUser(new User(null,"qwe168","666666","qwe168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"qwe168","666666",null)));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("qwe1682")){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}