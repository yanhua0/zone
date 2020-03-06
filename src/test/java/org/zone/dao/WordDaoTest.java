package org.zone.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zone.entity.Word;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class WordDaoTest {
    @Autowired
    private WordDao wordDao;
    @Test
    public void queryAll() {
       List<Word> word= wordDao.queryAll("1");
       System.out.println(word);
    }

    @Test
    public void insert() {
        wordDao.insert("1","222");
    }

    @Test
    public void count() {
        int count=wordDao.count();
        System.out.println(count);
    }
}