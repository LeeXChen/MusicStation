package com.atmusic.filter;

import com.atmusic.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author LIXICHEN
 * @create 2020-04-30 23:34
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        }else if("admin".equals(user.getUsername())) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            httpServletRequest.getRequestDispatcher("/pages/error/not_admin_error.jsp").forward(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
