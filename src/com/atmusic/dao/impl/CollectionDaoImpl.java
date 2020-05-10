package com.atmusic.dao.impl;

import com.atmusic.dao.CollectionDao;
import com.atmusic.pojo.Collection;
import com.atmusic.pojo.User;
import com.atmusic.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-29 0:54
 */
public class CollectionDaoImpl extends BaseDaoImpl<Collection> implements CollectionDao {

    Connection connection = null;

    @Override
    public int addMusicCollection(Collection collection) {
        connection = JdbcUtils.getConnection();
        String sql = "insert  into u_collection(`username`,`songname`,`singer`,`download_count`) " +
                "values (?,?,?,?)";
        return update(connection,sql,collection.getUsername(),collection.getSongname(),collection.getSinger(),collection.getDownloadCount());

    }

    @Override
    public int delete(Integer id) {
        connection = JdbcUtils.getConnection();
        String sql = "delete from u_collection where id = ?";
        return update(connection,sql,id);

    }

    @Override
    public int queryMusicCollection(Collection collection) {
        connection = JdbcUtils.getConnection();
        String sql = "SELECT * FROM u_collection WHERE username = ? and songname = ?";
        if(get(connection,sql,collection.getUsername(),collection.getSongname()) != null){
            return 1;
        }else {

            return -1;
        }
    }

    @Override
    public List<Collection> queryCollectionMusics(User user) {
        connection = JdbcUtils.getConnection();
        String sql = "SELECT `id`,`username`,`songname`,`singer`,`download_count` downloadCount " +
                "FROM u_collection WHERE username = ?";

        return getForList(connection,sql,user.getUsername());
    }


}
