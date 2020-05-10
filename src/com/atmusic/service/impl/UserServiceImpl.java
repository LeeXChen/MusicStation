package com.atmusic.service.impl;

import com.atmusic.dao.UserDao;
import com.atmusic.dao.impl.UserDaoImpl;
import com.atmusic.pojo.User;
import com.atmusic.service.UserService;

/**
 * @author LIXICHEN
 * @create 2020-04-20 20:23
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void regitUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }else {

            return true;
        }
    }
}
