package com.atmusic.test;

import com.atmusic.dao.CollectionDao;
import com.atmusic.dao.impl.CollectionDaoImpl;
import com.atmusic.pojo.Collection;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LIXICHEN
 * @create 2020-04-29 8:52
 */
public class CollectionDaoTest {

    Collection collection = new Collection(null,"qwe","qwe","qwe",5);
    CollectionDao collectionDao = new CollectionDaoImpl();

    @Test
    public void addMusicCollection() {
        collectionDao.addMusicCollection(collection);
    }

    @Test
    public void delete() {
        collectionDao.delete(1);
    }

    @Test
    public void queryMusicCollection() {
        System.out.println(collectionDao.queryMusicCollection(collection));;
    }

}