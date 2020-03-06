package org.zone.dao;

import org.apache.ibatis.annotations.Param;
import org.zone.entity.User;

public interface UserDao {
    User queryByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
}
