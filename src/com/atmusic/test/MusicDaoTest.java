package com.atmusic.test;

import com.atmusic.dao.MusicDao;
import com.atmusic.dao.impl.MusicDaoImpl;
import com.atmusic.pojo.Music;
import com.atmusic.utils.JdbcUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author LIXICHEN
 * @create 2020-04-24 16:26
 */
public class MusicDaoTest {

    private MusicDao musicDao = new MusicDaoImpl();

    @Test
    public void addMusic() {

        musicDao.addMusic(new Music(null,"测试333","测试","测试",
                            "测试","测试",0));
    }

    @Test
    public void deleteMusic() {

        musicDao.deleteMusic(53);

    }

    @Test
    public void updateMusic() {

        musicDao.updateMusic(new Music(53,"测试2","测试","测试",
                                    "测试","测试",100));
    }

    @Test
    public void queryMusicBySongname() {

        System.out.println(musicDao.queryMusicById(53));

    }

    @Test
    public void querySameMusic() {

        for (Music music : musicDao.querySameMusic(new Music(2, "晴天.mp3", "周杰伦",
                "流行", "/music/流行/", "static/img/周杰伦.jpg", 0))) {
            System.out.println(music);
        }

    }

    @Test
    public void queryMusics() {
        for (Music music : musicDao.queryMusics()) {
            System.out.println(music);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(musicDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Music music : musicDao.queryForPageItems(8, 4)) {
            System.out.println(music);
        }
    }

    @Test
    public void queryForPageTotalCountBySearch() {
        String condition = "周杰伦";
        System.out.println(musicDao.queryForPageTotalCountBySearch(condition));
    }

    @Test
    public void queryForPageItemsBySearch() {
        String condition = "周杰伦";
        for (Music music : musicDao.queryForPageItemsBySearch(1, 4,condition)) {
            System.out.println(music);
        }
    }
}