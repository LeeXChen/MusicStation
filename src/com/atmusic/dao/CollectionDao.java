package com.atmusic.dao;

import com.atmusic.pojo.Collection;
import com.atmusic.pojo.Music;
import com.atmusic.pojo.User;

import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-29 0:51
 */
public interface CollectionDao {

    /**
     * 添加音乐收藏信息
     * @param collection
     * @return
     */
    public int addMusicCollection(Collection collection);

    /**
     * 删除音乐下载信息
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 查询音乐收藏信息
     *
     * @param collection
     * @return
     */
    public int queryMusicCollection(Collection collection);

    /**
     * 根据用户查询所有收藏歌曲信息
     * @param user
     * @return
     */
    public List<Collection> queryCollectionMusics(User user);


}
