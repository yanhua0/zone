package org.zone.entity;

import java.util.Date;

public class Album {
    private String username;
    private String picture;
    private String infor;
    private String caption;
    private int id;
    private Date createTime;
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Album{" +
                "username='" + username + '\'' +
                ", picture='" + picture + '\'' +
                ", infor='" + infor + '\'' +
                ", caption='" + caption + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                '}';
    }
}
