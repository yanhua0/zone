package org.zone.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zone.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Autowired
    private  UserDao userDao;
    @Test
    public void queryByUsernameAndPassword() {
        User user=userDao.queryByUsernameAndPassword("1","1");
        System.out.println(user);
    }
}