package com.atmusic.dao;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;


/**
 * 访问数据的 DAO 接口
 * 里边定义好访问数据表的各种方法
 * @author LIXICHEN
 * @create 2020-04-20 17:43
 * @param T :DAO 处理的实体类的类型
 * @author LIXICHEN
 * @create 2020-04-13 15:59
 */
public interface DAO<T> {


    /**
     * 批量处理方法
     *
     * @param connection 数据库连接
     * @param sql        SQL 语句
     * @param args       填充占位符的Object [] 类型的可变参数
     */
    void batch(Connection connection, String sql, Object[]... args);

    /**
     * 返回具体的一个值 例如总人数，email
     *
     * @param connection 数据库连接
     * @param sql        SQL 语句
     * @param args       填充占位符的可变参数
     * @param <E>
     * @return
     * @throws SQLException
     */
    <E> E getForValue(Connection connection, String sql, Object... args);

    /**
     * 返回 T 的集合
     *
     * @param connection 数据库连接
     * @param sql        SQL 语句
     * @param args       填充占位符的可变参数
     * @return
     * @throws SQLException
     */
    List<T> getForList(Connection connection, String sql, Object... args);


    /**
     * 返回一个 T 的对象
     *
     * @param connection 数据库连接
     * @param sql        SQL 语句
     * @param args       填充占位符的可变参数
     * @return
     * @throws SQLException
     */
    T get(Connection connection, String sql, Object... args);


    /**
     * INSERT,UPDATE,DELETE
     *
     * @param connection : 数据库连接
     * @param sql        :SQL 语句
     * @param args       :填充占位符的可变参数
     * @return            如果返回-1,说明执行失败，返回其他表示影响的行数
     */
    int update(Connection connection, String sql, Object... args);

}


