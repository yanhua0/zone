package org.zone.service;

import org.zone.entity.User;

public interface UserService {
    User login(String username, String password);
}
