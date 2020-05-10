package com.atmusic.web;

import com.atmusic.dao.CollectionDao;
import com.atmusic.dao.impl.MusicDaoImpl;
import com.atmusic.pojo.Collection;
import com.atmusic.pojo.Music;
import com.atmusic.pojo.Page;
import com.atmusic.pojo.User;
import com.atmusic.service.MusicCollectService;
import com.atmusic.service.MusicService;
import com.atmusic.service.impl.MusicCollectServiceImpl;
import com.atmusic.service.impl.MusicServiceImpl;
import com.atmusic.utils.WebUtils;
import com.google.gson.Gson;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LIXICHEN
 * @create 2020-04-26 12:31
 */
public class ClientMusicServlet extends BaseServlet {

    private MusicService musicService = new MusicServiceImpl();
    private MusicCollectService musicCollectService = new MusicCollectServiceImpl();

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
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 8);
        //2 调用Music.page(pageNO,pageSize)生成page对象
        Page<Music> page = musicService.page(pageNo, pageSize);

        //设置url
        page.setUrl("client/musicServlet?action=page");

        //3 保存page对象到Request域中
        req.setAttribute("page", page);
        //4 请求转发到pages/manager/music_manager.jsp页面
        req.getRequestDispatcher("/pages/client/home.jsp").forward(req, resp);


    }


    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageBySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //1 获取请求参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 8);
        String condition = req.getParameter("condition");
        //2 调用Music.page(pageNO,pageSize)生成page对象
        Page<Music> page = musicService.pageBySearch(pageNo, pageSize, condition);

        StringBuilder sb = new StringBuilder("client/musicServlet?action=pageBySearch");
        if (req.getParameter("condition") != null) {
            sb.append("&condition=").append(req.getParameter("condition"));
        }

        //设置url
        page.setUrl(sb.toString());

        //3 保存page对象到Request域中
        req.setAttribute("page", page);
        //4 请求转发到pages/manager/music_manager.jsp页面
        req.getRequestDispatcher("/pages/client/home.jsp").forward(req, resp);


    }

    /**
     * 播放音乐
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void musicPlay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取music对象
        Integer id = Integer.valueOf(req.getParameter("id"));
        Music music = musicService.queryMusicById(id);
        //获取请求参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);


        //保存music对象到Request域中
        req.setAttribute("music", music);
        req.setAttribute("pageNo", pageNo);

        //请求转发到/pages/client/music_play.jsp页面
        req.getRequestDispatcher("/pages/client/music_play.jsp").forward(req, resp);

    }

    /**
     * 下载
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void download(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取music对象
        Integer id = Integer.valueOf(req.getParameter("id"));
        Music music = musicService.queryMusicById(id);

        //下载次数+1
        int downloadCount = music.getDownloadCount() + 1;
        music.setDownloadCount(downloadCount);
        musicService.updateMusic(music);

        //1、获取要下载的文件名
        String downloadMusic = music.getSongname().split("\\.")[0];
        String downloadSinger = music.getSinger();
        String downloadFileName = downloadMusic+ "——" + downloadSinger+".mp3";
        String downloadUrl = music.getLocation();

        //2、读取要下载的文件内容 (通过ServletContext对象可以读取)
        ServletContext servletContext = getServletContext();

        // 获取要下载的文件类型
        String mimeType = servletContext.getMimeType(downloadUrl + downloadFileName);
        //System.out.println("下载的文件类型：" + mimeType);

        //4、在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        // 5、还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
//        Content-Disposition响应头，表示收到的数据怎么处理
//         attachment表示附件，表示下载使用
//         filename= 表示指定下载的文件名
//         url编码是把汉字转换成为%xx%xx的格式
        try {
            if (req.getHeader("User-Agent").contains("Firefox")) {
                // 如果是火狐浏览器使用Base64编码
                resp.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" + new BASE64Encoder().encode(downloadFileName.getBytes("UTF-8")) + "?=");
            } else {
                // 如果不是火狐，是IE或谷歌，使用URL编码操作

                resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downloadFileName, "UTF-8"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * /斜杠被服务器解析表示地址为http://ip:prot/工程名/  映射 到代码的Web目录
         */
        InputStream resourceAsStream = servletContext.getResourceAsStream(downloadUrl + music.getSongname());

        // 获取响应的输出流
        OutputStream outputStream = null;


        try {
            outputStream = resp.getOutputStream();

            //3、把下载的文件内容回传给客户端
            // 读取输入流中全部的数据，复制给输出流，输出给客户端
            IOUtils.copy(resourceAsStream, outputStream);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    /**
     * 收藏
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void collect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取music对象
        Integer id = Integer.valueOf(req.getParameter("id"));
        Music music = musicService.queryMusicById(id);
        int count = Integer.parseInt(req.getParameter("count"));
        //获取当前登录对象
        User user = (User) req.getSession().getAttribute("user");
        //生成collection对象
        Collection collection = new Collection();
        collection.setUsername(user.getUsername());
        collection.setSongname(music.getSongname());
        collection.setSinger(music.getSinger());
        collection.setDownloadCount(music.getDownloadCount());
        if(!musicCollectService.exist(collection)){
            musicCollectService.add(collection);
        }
        if(count==1){
            List<Music> musics = musicService.querySameMusic(music);
            req.setAttribute("musics",musics);
            req.setAttribute("collectId",id);
            req.getRequestDispatcher("/pages/music/show.jsp").forward(req, resp);
        }else {
            int countId = Integer.parseInt(req.getParameter("collectId"));
            resp.sendRedirect(req.getContextPath() + "/client/musicServlet?action=collect&id=" +countId+"&count=1");
        }
    }


}
