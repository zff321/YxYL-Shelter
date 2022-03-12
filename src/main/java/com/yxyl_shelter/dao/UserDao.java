package com.yxyl_shelter.dao;

import com.yxyl_shelter.domain.User;

public interface UserDao {

    /**
     * 查询USer
     * @param u_username
     * @param u_password
     * @return
     */
    User findUserByUsernameAndPassword(String u_username, String u_password);
}
