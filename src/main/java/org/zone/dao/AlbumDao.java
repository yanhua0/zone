package org.zone.dao;

import org.apache.ibatis.annotations.Param;
import org.zone.entity.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> queryAll(String username);
    int insert(@Param("username")String username, @Param("picture")String picture,
               @Param("infor")String infor,@Param("caption")String caption);
}
