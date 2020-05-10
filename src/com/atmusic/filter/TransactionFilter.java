package com.atmusic.filter;

import com.atmusic.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LIXICHEN
 * @create 2020-05-01 1:05
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try{

            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();//提交事务
        }catch(Exception e){
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            //把异常抛出到Tomcat，显示错误页面
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}
