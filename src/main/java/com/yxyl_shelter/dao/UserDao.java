package com.yxyl_shelter.dao;

import com.yxyl_shelter.domain.User;

public interface UserDao {

    /**
     * 查询UserByUsernameAndPassword
     * @param u_username
     * @param u_password
     * @return
     */
    User findUserByUsernameAndPassword(String u_username, String u_password);

    /**
     * 查询UserByUsername
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 保存User
     * @param u
     */
    void save(User u);
}
