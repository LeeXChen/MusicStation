package com.atmusic.web;

import com.atmusic.dao.impl.MusicDaoImpl;
import com.atmusic.pojo.Music;
import com.atmusic.pojo.Page;
import com.atmusic.service.MusicService;
import com.atmusic.service.impl.MusicServiceImpl;
import com.atmusic.utils.WebUtils;
import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-23 16:46
 */
public class MusicServlet extends BaseServlet {

    private MusicService musicService = new MusicServiceImpl();

    /**
     * 添加
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;

        //获取请求参数，封装为Music对象
        Music music = WebUtils.copyParamToBean(req.getParameterMap(), new Music());
        //调用 MusicService.addMusic() 保存音乐
        musicService.addMusic(music);
        //跳转到音乐列表页面 manager/musicServlet?action=list
//        req.getRequestDispatcher("manager/musicServlet?action=page").forward(req,resp);存在bug，应使用重定向
        resp.sendRedirect(req.getContextPath() + "/manager/musicServlet?action=page&pageNo=" + pageNo);

    }

    /**
     * 删除
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用 MusicService.deleteMusic() 方法
        musicService.deleteMusic(id);
        //重定向到音乐管理页面 manager/musicServlet?action=page
        resp.sendRedirect(req.getContextPath() + "/manager/musicServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    /**
     * 修改
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数,封装为Music对象
        Music music = WebUtils.copyParamToBean(req.getParameterMap(), new Music());
        //调用MusicService.updateMusic()方法
        musicService.updateMusic(music);
        //跳转到音乐列表分页页面 manager/musicServlet?action=page
        resp.sendRedirect(req.getContextPath() + "/manager/musicServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    /**
     * 查询图书信息，并回显
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getMusic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用MusicService.queryMusicById()查询图书
        Music music = musicService.queryMusicById(id);
        //保存图书到Request域中
        req.setAttribute("music", music);
        //请求转发到 manager/music_edit.jsp 页面
        req.getRequestDispatcher("/pages/manager/music_edit.jsp").forward(req, resp);

    }

    /**
     * 查询全部音乐
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.通过MusicService查询全部图书
        List<Music> musics = musicService.queryMusics();
        //2.把全部音乐保存到Request域中
        req.setAttribute("musics", musics);
        //3.请求转发到 /pages/manager/music_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/music_manager.jsp").forward(req, resp);

    }

    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用Music.page(pageNO,pageSize)生成page对象
        Page<Music> page = musicService.page(pageNo, pageSize);

        //设置url
        page.setUrl("manager/musicServlet?action=page");

        //3 保存page对象到Request域中
        req.setAttribute("page", page);
        //4 请求转发到pages/manager/music_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/music_manager.jsp").forward(req, resp);


    }



}
