package org.zone.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zone.entity.Album;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AlbumDaoTest {
    @Autowired
    private AlbumDao albumDao;
    @Test
    public void queryAll() {
        List<Album> albums=albumDao.queryAll("1");
        System.out.println(albums);
    }
}