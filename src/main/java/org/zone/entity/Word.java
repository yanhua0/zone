package org.zone.entity;

import java.util.Date;

public class Word {
    private String username;
    private String word;
    private int id;
    private Date createTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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
        return "word{" +
                "username='" + username + '\'' +
                ", word='" + word + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                '}';
    }
}
