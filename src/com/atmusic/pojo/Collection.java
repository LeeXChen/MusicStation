package com.atmusic.pojo;

/**
 * @author LIXICHEN
 * @create 2020-04-29 0:40
 */
public class Collection {

    private Integer id;
    private String username;
    private String songname;
    private String singer;
    private Integer downloadCount;

    public Collection() {
    }

    public Collection(Integer id, String username, String songname, String singer, Integer downloadCount) {
        this.id = id;
        this.username = username;
        this.songname = songname;
        this.singer = singer;
        this.downloadCount = downloadCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", songname='" + songname + '\'' +
                ", singer='" + singer + '\'' +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
