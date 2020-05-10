package com.atmusic.service;

import com.atmusic.pojo.Music;
import com.atmusic.pojo.Page;

import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-24 17:19
 */
public interface MusicService {

    /**
     * 添加音乐信息
     * @param music
     * @return
     */
    public void addMusic(Music music);

    /**
     * 删除音乐信息
     * @param id
     * @return
     */
    public void deleteMusic(Integer id);

    /**
     * 修改音乐信息
     * @param music
     * @return
     */
    public void updateMusic(Music music);


    /**
     * 根据歌曲名查询歌曲信息
     *
     * @param id 歌曲编号
     * @return 歌曲
     */
    public Music queryMusicById(Integer id);




    /**
     * 查询相同歌手、风格、地域的歌曲信息
     * @param music 歌曲信息
     * @return 相同类型的歌曲
     */
    public List<Music> querySameMusic(Music music);


    /**
     * 查询所有歌曲信息
     * @return
     */
    public List<Music> queryMusics();

    /**
     * 生成分页对象
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Music> page(int pageNo, int pageSize);

    /**
     * 根据查询条件生成分页对象
     * @param pageNo
     * @param pageSize
     * @param condition
     * @return
     */
    Page<Music> pageBySearch(int pageNo, int pageSize, String condition);

    /**
     * 根据歌曲名查询歌曲信息
     * @param songname
     * @return
     */
    public Music queryMusicBySongname(String songname);
}
