package com.atmusic.dao;

import com.atmusic.pojo.Music;

import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-23 17:11
 */
public interface MusicDao {


    /**
     * 添加音乐信息
     * @param music
     * @return
     */
    public int addMusic(Music music);

    /**
     * 删除音乐信息
     * @param id
     * @return
     */
    public int deleteMusic(Integer id);

    /**
     * 修改音乐信息
     * @param music
     * @return
     */
    public int updateMusic(Music music);


    /**
     * 根据歌曲名查询歌曲信息
     *
     * @param id 歌曲id
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
     * 获取分页总记录数
     * @return
     */
    Integer queryForPageTotalCount();

    /**
     * 获取每一页的数据
     * @param begin
     * @param pageSize
     * @return
     */
    List<Music> queryForPageItems(int begin, int pageSize);

    /**
     * 根据搜索条件获取分页总记录数
     * @param condition
     * @return
     */
    Integer queryForPageTotalCountBySearch(String condition);

    /**
     * 根据搜索条件获取每一页的数据
     * @param begin
     * @param pageSize
     * @param condition
     * @return
     */
    List<Music> queryForPageItemsBySearch(int begin, int pageSize, String condition);

    /**
     * 根据歌曲名查询歌曲信息
     * @param songname
     * @return
     */
    public Music queryMusicBySongname(String songname);
}
