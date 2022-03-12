package com.yxyl_shelter.service;

import com.yxyl_shelter.domain.User;

public interface UserService {

    /**
     * 根据name查询User
     * @param user
     * @return
     */
    User findUserByName(User user);

    /**
     * 注册USer
     * @param user
     * @return
     */
    boolean register(User user);

}
