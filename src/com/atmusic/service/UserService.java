package com.atmusic.service;

import com.atmusic.pojo.User;

/**
 * @author LIXICHEN
 * @create 2020-04-20 20:16
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void regitUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回 null 则说明登陆失败 ，反之亦然
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @return 返回 true 表示用户名已存在，返回 false 表示用户名可用
     */
    public boolean existsUsername(String username);


}
