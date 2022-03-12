package com.yxyl_shelter.service;

import com.yxyl_shelter.domain.User;

public interface UserService {

    /**
     * 根据name查询User
     * @param user
     * @return
     */
    User findUserByName(User user);
}
