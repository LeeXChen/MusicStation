package com.atmusic.test;

import com.atmusic.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author LIXICHEN
 * @create 2020-04-20 17:17
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {

        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);

        }

    }

}
