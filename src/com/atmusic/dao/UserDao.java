package com.atmusic.dao;

import com.atmusic.pojo.User;

/**
 * @author LIXICHEN
 * @create 2020-04-20 18:10
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回 null ，说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回 null ，说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 如果返回-1,说明执行失败，返回其他表示影响的行数
     */
    public int saveUser(User user);

}
