package org.zone.dao;

import org.apache.ibatis.annotations.Param;
import org.zone.entity.Word;

import java.util.List;

public interface WordDao {
    List<Word> queryAll(String username);
    int insert(@Param("username")String username,@Param("word")String word);
    int delete(int id);
    int count();
    Word queryById(int id);
}
