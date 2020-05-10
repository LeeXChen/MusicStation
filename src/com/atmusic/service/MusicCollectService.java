package com.atmusic.service;

import com.atmusic.pojo.Collection;
import com.atmusic.pojo.Music;
import com.atmusic.pojo.Page;
import com.atmusic.pojo.User;


import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-29 1:21
 */
public interface MusicCollectService {

    /**
     * 添加音乐收藏信息
     * @param collection
     * @return
     */
    public void add(Collection collection);

    /**
     * 删除音乐收藏信息
     * @param id
     * @return
     */
    public void delete(Integer id);

    /**
     * 查询音乐收藏信息是否存在
     *
     * @param collection
     * @return true:存在 false：不存在
     */
    public boolean exist(Collection collection);

    /**
     * 根据用户信息查询所有收藏歌曲信息
     * @param user
     * @return
     */
    public List<Collection> queryCollectionMusics(User user);

}
