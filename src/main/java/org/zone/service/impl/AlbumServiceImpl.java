package org.zone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zone.dao.AlbumDao;
import org.zone.entity.Album;
import org.zone.service.AlbumService;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    public List<Album> queryAll(String username) {
        return albumDao.queryAll(username);
    }

    public void insert(String username, String picture, String infor,String caption) {
        albumDao.insert(username,picture,infor,caption);
    }
}
