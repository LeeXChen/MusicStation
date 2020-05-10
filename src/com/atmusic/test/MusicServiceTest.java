package com.atmusic.test;

import com.atmusic.pojo.Music;
import com.atmusic.pojo.Page;
import com.atmusic.service.MusicService;
import com.atmusic.service.impl.MusicServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LIXICHEN
 * @create 2020-04-24 17:32
 */
public class MusicServiceTest {

    private MusicService musicService = new MusicServiceImpl();

    @Test
    public void addMusic() {
        musicService.addMusic(new Music(null,"测试","测试","测试",
                "测试","测试",0));
    }

    @Test
    public void deleteMusic() {
        musicService.deleteMusic(53);
    }

    @Test
    public void updateMusic() {
        musicService.updateMusic(new Music(53,"测试333","测试","测试",
                "测试","测试",99));
    }

    @Test
    public void queryMusicBySongname() {
        System.out.println(musicService.queryMusicById(53));
    }

    @Test
    public void querySameMusic() {
        for (Music music : musicService.querySameMusic(new Music(2, "晴天.mp3", "周杰伦",
                "流行", "/music/流行/", "static/img/周杰伦.jpg", 0))) {
            System.out.println(music);
        }
    }

    @Test
    public void queryMusics() {
        for (Music music : musicService.queryMusics()) {
            System.out.println(music);
        }
    }

    @Test
    public void page(){

        System.out.println(musicService.page(1, 5));

    }

    @Test
    public void pageBySearch(){

        String condition = "周杰伦";

        System.out.println(musicService.pageBySearch(1, 4,condition));

    }
    @Test
    public void stringT(){

        String downloadMusic = "少年.mp3";
        String[] downloadMusics = downloadMusic.split("\\.");
        System.out.println(downloadMusics.length);

    }

}