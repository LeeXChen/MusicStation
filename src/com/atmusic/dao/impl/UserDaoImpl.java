package com.atmusic.dao.impl;

import com.atmusic.dao.UserDao;
import com.atmusic.pojo.User;
import com.atmusic.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @author LIXICHEN
 * @create 2020-04-20 18:15
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    private Connection connection = null;

    @Override
    public User queryUserByUsername(String username) {
        connection = JdbcUtils.getConnection();
        String sql = "select * from m_user where username = ?";
        return get(connection, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        connection = JdbcUtils.getConnection();
        String sql = "select * from m_user where username = ? and password = ?";
        return get(connection, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        connection = JdbcUtils.getConnection();
        String sql = "INSERT INTO  m_user (username,PASSWORD,email) VALUES (?,?,?)";

        return update(connection, sql,user.getUsername(), user.getPassword(),user.getEmail());
    }
}
