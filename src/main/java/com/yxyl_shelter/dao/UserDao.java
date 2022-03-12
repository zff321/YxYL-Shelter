package com.yxyl_shelter.dao;

import com.yxyl_shelter.domain.User;

public interface UserDao {
    /**
     *
     * @param user
     * @return
     */
    User findUserByName(User user);
}
