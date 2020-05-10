package com.atmusic.dao.impl;


import com.atmusic.dao.DAO;
import com.atmusic.utils.JdbcUtils;
import com.atmusic.utils.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-20 17:24
 */
public class BaseDaoImpl<T> implements DAO<T> {

    private QueryRunner queryRunner = null;
    private Class<T> type;

    public BaseDaoImpl() {
        queryRunner = new QueryRunner();
        type = ReflectionUtils.getSuperGenericType(getClass());
    }

    @Override
    public void batch(Connection connection, String sql, Object[]... args){

        try {
            queryRunner.batch(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    @Override
    public <E> E getForValue(Connection connection, String sql, Object... args){

        try {
            return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<T> getForList(Connection connection, String sql, Object... args){
        try {

            return (List<T>) queryRunner.query(connection, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    @Override
    public T get(Connection connection, String sql, Object... args){
        try {
            return queryRunner.query(connection, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    @Override
    public int update(Connection connection, String sql, Object... args){

        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }



}
