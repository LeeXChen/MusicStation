package com.atmusic.web;


import com.atmusic.pojo.Collection;
import com.atmusic.pojo.Music;
import com.atmusic.pojo.User;
import com.atmusic.service.MusicCollectService;
import com.atmusic.service.MusicService;
import com.atmusic.service.impl.MusicCollectServiceImpl;
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
 * @create 2020-04-29 17:32
 */
public class CollectionServlet extends BaseServlet {

    private MusicCollectService musicCollectService = new MusicCollectServiceImpl();
    private MusicService musicService = new MusicServiceImpl();

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用 musicCollectService.deleteMusic() 方法
        musicCollectService.delete(id);
        //重定向到音乐管理页面 manager/musicServlet?action=page
        resp.sendRedirect(req.getContextPath() + "/client/collectionServlet?action=list");
    }

    protected void collectionMusicPlay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取music对象
        String songname = req.getParameter("songname");
        Music music = musicService.queryMusicBySongname(songname);
        //保存music对象到Request域中
        req.setAttribute("music", music);

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
        String songname = req.getParameter("songname");
        Music music = musicService.queryMusicBySongname(songname);

        //下载次数+1
        int downloadCount = music.getDownloadCount() + 1;
        music.setDownloadCount(downloadCount);
        musicService.updateMusic(music);

        //1、获取要下载的文件名
        String downloadMusic = music.getSongname().split("\\.")[0];
        String downloadSinger = music.getSinger();
        String downloadFileName = downloadMusic + "——" + downloadSinger + ".mp3";
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
        InputStream resourceAsStream = servletContext.getResourceAsStream(downloadUrl + downloadFileName);

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

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取当前登录对象
        User user = (User) req.getSession().getAttribute("user");
        //生成collection对象
        List<Collection> collections = musicCollectService.queryCollectionMusics(user);
        req.setAttribute("collections", collections);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }
}
