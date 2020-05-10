package com.atmusic.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author LIXICHEN
 * @create 2020-04-24 2:02
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决post请求额中文乱码问题
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        //解决响应中文乱码
        resp.setContentType("text/html; charset=UTF-8");

        //利用反射优化if-else代码
        try {
            //通过反射获取函数名称
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            //调用函数
            method.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
            //把异常抛给Filter过滤器
            throw new RuntimeException(e);
        }

    }

}
