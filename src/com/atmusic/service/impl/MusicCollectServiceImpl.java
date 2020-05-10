package com.atmusic.service.impl;

import com.atmusic.dao.CollectionDao;
import com.atmusic.dao.impl.CollectionDaoImpl;
import com.atmusic.pojo.Collection;
import com.atmusic.pojo.Music;
import com.atmusic.pojo.Page;
import com.atmusic.pojo.User;
import com.atmusic.service.MusicCollectService;

import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-29 1:30
 */
public class MusicCollectServiceImpl implements MusicCollectService {
    private CollectionDao collectionDao = new CollectionDaoImpl();
    @Override
    public void add(Collection collection) {
        collectionDao.addMusicCollection(collection);
    }

    @Override
    public void delete(Integer id) {
        collectionDao.delete(id);
    }

    @Override
    public boolean exist(Collection collection) {
        int res = collectionDao.queryMusicCollection(collection);
        if(res != -1){
            return true;
        }
        return false;
    }

    @Override
    public List<Collection> queryCollectionMusics(User user) {
        return collectionDao.queryCollectionMusics(user);
    }


}
