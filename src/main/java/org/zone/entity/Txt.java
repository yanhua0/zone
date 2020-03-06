package org.zone.entity;

public class Txt {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Txt{" +
                "id=" + id +
                '}';
    }
}
