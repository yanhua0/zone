package org.zone.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zone.dao.UserDao;
import org.zone.entity.User;
import org.zone.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;
    public User login(String username, String password) {
       User user=userDao.queryByUsernameAndPassword(username,password);
       if(user!=null)
       {   logger.info("user{}",user);
           return  user;

       }
       logger.error("账户或密码错误！");
       return null;
    }
}
