package org.zone.service;

import org.zone.entity.Word;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface WordService {
    List<Word> queryByUsername(String username,HttpServletRequest request);
    void insert(String username,String word);
    void delete(int id,HttpServletRequest request);
    int count();
}
