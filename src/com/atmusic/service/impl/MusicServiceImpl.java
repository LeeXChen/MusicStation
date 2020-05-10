package com.atmusic.service.impl;

import com.atmusic.dao.MusicDao;
import com.atmusic.dao.impl.MusicDaoImpl;
import com.atmusic.pojo.Music;
import com.atmusic.pojo.Page;
import com.atmusic.service.MusicService;

import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-24 17:28
 */
public class MusicServiceImpl implements MusicService {

    private MusicDao musicDao = new MusicDaoImpl();

    @Override
    public void addMusic(Music music) {
        musicDao.addMusic(music);
    }

    @Override
    public void deleteMusic(Integer id) {
        musicDao.deleteMusic(id);
    }

    @Override
    public void updateMusic(Music music) {
        musicDao.updateMusic(music);
    }

    @Override
    public Music queryMusicById(Integer id) {
        return musicDao.queryMusicById(id);
    }

    @Override
    public Music queryMusicBySongname(String songname) {
        return musicDao.queryMusicBySongname(songname);
    }

    @Override
    public List<Music> querySameMusic(Music music) {
        return musicDao.querySameMusic(music);
    }

    @Override
    public List<Music> queryMusics() {
        return musicDao.queryMusics();
    }

    @Override
    public Page<Music> page(int pageNo, int pageSize) {
        Page<Music> page = new Page<Music>();

        //求总记录数
        Integer pageTotalCount = musicDao.queryForPageTotalCount();

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0) {
            pageTotal++;
        }

        /*数据边界的有效检查*/
        if(pageNo<1){
            pageNo = 1;
        }else if(pageNo>pageTotal){
            pageNo = pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //设置总页码
        page.setPageTotal(pageTotal);


        //求当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        //获取当前页数据
        List<Music> items = musicDao.queryForPageItems(begin, pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Music> pageBySearch(int pageNo, int pageSize, String condition) {

        Page<Music> page = new Page<Music>();

        //求总记录数
        Integer pageTotalCount = musicDao.queryForPageTotalCountBySearch(condition);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0) {
            pageTotal++;
        }

        /*数据边界的有效检查*/
        if(pageNo<1){
            pageNo = 1;
        }else if(pageNo>pageTotal){
            pageNo = pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);

        //设置每页显示的数量
        page.setPageSize(pageSize);

        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //设置总页码
        page.setPageTotal(pageTotal);


        //求当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        //获取当前页数据
        List<Music> items = musicDao.queryForPageItemsBySearch(begin, pageSize, condition);
        //设置当前页数据
        page.setItems(items);

        return page;
    }


}
