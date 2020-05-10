package com.atmusic.test;

import com.atmusic.dao.CollectionDao;
import com.atmusic.dao.impl.CollectionDaoImpl;
import com.atmusic.pojo.Collection;
import com.atmusic.service.MusicCollectService;
import com.atmusic.service.impl.MusicCollectServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LIXICHEN
 * @create 2020-04-29 8:42
 */
public class MusicCollectServiceTest {

    MusicCollectService musicCollectService = new MusicCollectServiceImpl();
    Collection collection = new Collection(null,"qwe","qwe","qwe",5);

    @Test
    public void add() {
        musicCollectService.add(collection);
    }

    @Test
    public void delete() {
    }

    @Test
    public void exist() {
        System.out.println(musicCollectService.exist(collection));
    }


}