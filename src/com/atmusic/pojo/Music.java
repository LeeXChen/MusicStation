package com.atmusic.pojo;

/**
 * @author LIXICHEN
 * @create 2020-04-20 16:46
 */
public class Music {

    private Integer id;
    private Integer downloadCount;
    private String songname;
    private String singer;
    private String style;
    private String location;
    private String imgPath = "static/img/default.jpg";

    public Music() {
    }

    public Music(Integer id, String songname, String singer, String style, String location, String imgPath, Integer downloadCount) {
        this.id = id;
        this.songname = songname;
        this.singer = singer;
        this.style = style;
        this.location = location;
        this.downloadCount = downloadCount;
        if (imgPath != null && !"".equals(imgPath)) {

            this.imgPath = imgPath;
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {

        if (imgPath != null && !"".equals(imgPath)) {

            this.imgPath = imgPath;
        }

    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", songname='" + songname + '\'' +
                ", singer='" + singer + '\'' +
                ", style='" + style + '\'' +
                ", location='" + location + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
