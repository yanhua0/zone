package org.zone.service;

import org.zone.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> queryAll(String username);
    void insert(String username,String picture,String infor,String caption);
}
