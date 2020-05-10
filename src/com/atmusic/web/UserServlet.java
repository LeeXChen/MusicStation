package com.atmusic.web;

import com.atmusic.pojo.User;
import com.atmusic.service.UserService;
import com.atmusic.service.impl.UserServiceImpl;
import com.atmusic.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author LIXICHEN
 * @create 2020-04-24 1:16
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 处理登陆的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //处理登录业务
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用Service方法处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        //3.根据login方法返回结果判断时候登陆成功 null:登录失败
        if (loginUser == null) {
            //登陆失败

            //把错误信息和回显表单项信息，保存到request域中
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
            req.setAttribute("password", password);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登陆成功
            //保存用户信息到session中
            req.getSession().setAttribute("user", loginUser);
            //判断管理员权限
            //免用户名登录
            Cookie cookie = new Cookie("username", username);
            //当前 cookie 30s内有效
            cookie.setMaxAge(30);
            resp.addCookie(cookie);
            //登陆成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }

    /**
     * 处理注册的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //处理注册业务
        //1.获取请求参数
        //获取验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String repwd = req.getParameter("repwd");
        String code = req.getParameter("code");

        //通过Beanutil工具类简化参数获取的代码
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2.检查验证码是否正确
        if (token !=null && token.equalsIgnoreCase(code)) {

            //3.检查用户名是否可用
            if (userService.existsUsername(user.getUsername())) {
                //用户名不可用
                //把错误信息和回显表单项信息，保存到request域中
                req.setAttribute("msg", "用户名 " + user.getUsername() + " 已存在！");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("password", user.getPassword());
                req.setAttribute("repwd", repwd);
                req.setAttribute("email", user.getEmail());
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);


            } else {
                //用户名可用
                //调用Service保存到数据库
                userService.regitUser(new User(null, user.getUsername(), user.getPassword(), user.getEmail()));
                //调到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);


            }

        } else {
            //不正确
            //把错误信息和回显表单项信息，保存到request域中
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("password", user.getPassword());
            req.setAttribute("repwd", repwd);
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);

        }

    }


    /**
     * 处理注销功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //销毁Session中的用户信息（销毁Session）
        req.getSession().invalidate();
        //重定向到首页或者登录页面
        resp.sendRedirect(req.getContextPath());

    }


    /**
     * 检测用户名是否可用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求参数username
        String username = req.getParameter("username");
        //调用userservice.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成map对象
        Map<String,Object> resultmap =  new HashMap<String, Object>();
        resultmap.put("existsUsername",existsUsername);

        //map转换为json对象
        Gson gson = new Gson();
        String json = gson.toJson(resultmap);

        //返回json对象
        resp.getWriter().write(json);


    }


}
