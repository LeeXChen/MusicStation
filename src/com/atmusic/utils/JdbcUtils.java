package com.atmusic.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.atmusic.pojo.Collection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LIXICHEN
 * @create 2020-04-20 16:50
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();


    static {
        try {
            Properties properties = new Properties();
            //读取 jdbc.properties 属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取数据库连接池中的连接
     * 并实现事务管理
     *
     * @return 如果返回 null 说明获取连接失败
     */
    public static Connection getConnection() {

        Connection connection = conns.get();

        if (connection == null) {
            try {

                connection = dataSource.getConnection();

                //保存到ThreadLocal中，供后面的jdbc操作
                conns.set(connection);

                //设置为手动管理
                connection.setAutoCommit(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;

    }

    /**
     * 提交事务，并关闭数据库
     *
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        //如果不等于null，说明以前使用过连接
        if(connection != null){

            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        conns.remove();
    }

    /**
     * 回滚事务，并关闭数据库
     *
     */
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        //如果不等于null，说明以前使用过连接
        if(connection != null){

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        conns.remove();

    }


}
