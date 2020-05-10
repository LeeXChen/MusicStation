package com.atmusic.dao.impl;

import com.atmusic.dao.MusicDao;
import com.atmusic.pojo.Music;
import com.atmusic.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author LIXICHEN
 * @create 2020-04-23 17:16
 */
public class MusicDaoImpl extends BaseDaoImpl<Music> implements MusicDao {

    private Connection connection = null;

    @Override
    public int addMusic(Music music) {
        connection = JdbcUtils.getConnection();
        String sql = "insert  into m_music(`songname`,`singer`,`style`,`location`,`img_path`,`download_count`) " +
                "values (?,?,?,?,?,?)";
        return update(connection,sql,music.getSongname(),music.getSinger(),music.getStyle(),music.getLocation(),music.getImgPath(),music.getDownloadCount());
    }

    @Override
    public int deleteMusic(Integer id) {

        connection = JdbcUtils.getConnection();

        String sql = "delete from m_music where id = ?";

        return update(connection,sql,id);
    }

    @Override
    public int updateMusic(Music music) {
        connection = JdbcUtils.getConnection();

        String sql = "update m_music set `songname`=?,`singer`=?,`style`=?,`location`=?,`img_path`=?,`download_count`=? where id = ?";

        return update(connection,sql,music.getSongname(),music.getSinger(),
                        music.getStyle(),music.getLocation(),music.getImgPath(),music.getDownloadCount(),music.getId());
    }

    @Override
    public Music queryMusicById(Integer id) {

        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`songname`,`singer`,`style`,`location`,`img_path` imgPath,`download_count` downloadCount from m_music where id = ?";

        return get(connection, sql, id);

    }

    @Override
    public Music queryMusicBySongname(String songname) {
        connection = JdbcUtils.getConnection();
        String sql = "select `id`,`songname`,`singer`,`style`,`location`,`img_path` imgPath,`download_count` downloadCount from m_music where songname = ?";

        return get(connection, sql, songname);
    }

    @Override
    public List<Music> querySameMusic(Music music) {

        connection = JdbcUtils.getConnection();
        String sql = "SELECT `id`,`songname`,`singer`,`style`,`location`,`img_path` imgPath,`download_count` downloadCount " +
                    "FROM ( SELECT * FROM m_music WHERE id <> ?)p " + "WHERE p.singer = ? OR p.style = ?";

        return getForList(connection,sql,music.getId(),music.getSinger(),music.getStyle());
    }

    @Override
    public List<Music> queryMusics() {

        connection = JdbcUtils.getConnection();
        String sql = "SELECT `id`,`songname`,`singer`,`style`,`location`,`img_path` imgPath,`download_count` downloadCount FROM m_music";

        return getForList(connection,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        connection = JdbcUtils.getConnection();
        String sql = "SELECT COUNT(*) FROM m_music";
        Number count = (Number) getForValue(connection,sql);
        return count.intValue();
    }

    @Override
    public List<Music> queryForPageItems(int begin, int pageSize) {
        connection = JdbcUtils.getConnection();
        String sql = "SELECT `id`,`songname`,`singer`,`style`,`location`,`img_path` imgPath,`download_count` downloadCount FROM m_music LIMIT ?,?";
        return getForList(connection,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountBySearch(String condition) {
        connection = JdbcUtils.getConnection();
        String sql = "SELECT COUNT(*) FROM m_music WHERE songname LIKE '%"+condition+"%' OR singer LIKE '%"+condition+"%'";
        Number count = (Number) getForValue(connection,sql);
        return count.intValue();
    }

    @Override
    public List<Music> queryForPageItemsBySearch(int begin, int pageSize, String condition) {

        connection = JdbcUtils.getConnection();
        String sql = "SELECT `id`,`songname`,`singer`,`style`,`location`,`img_path` imgPath,`download_count` downloadCount " +
                "FROM m_music WHERE songname LIKE '%"+condition+"%' OR singer LIKE '%"+condition+"%' LIMIT ?,?";
        return getForList(connection,sql,begin,pageSize);

    }




}
