package com.atmusic.test;

import com.atmusic.dao.UserDao;
import com.atmusic.dao.impl.UserDaoImpl;
import com.atmusic.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LIXICHEN
 * @create 2020-04-20 18:39
 */
public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }


    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsernameAndPassword("admin", "admin")==null){
            System.out.println("用户名或密码错误，登陆失败！");
        }else {
            System.out.println("登陆成功！");

        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null,"admin2","123456","admin@qq.com")));

    }
}