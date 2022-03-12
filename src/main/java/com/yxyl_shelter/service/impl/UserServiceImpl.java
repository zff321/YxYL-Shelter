package com.yxyl_shelter.service.impl;

import com.yxyl_shelter.dao.UserDao;
import com.yxyl_shelter.dao.impl.UserDaoImpl;
import com.yxyl_shelter.domain.User;
import com.yxyl_shelter.service.UserService;
import com.yxyl_shelter.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserServiceImpl implements UserService {


    private UserDao userDao = new UserDaoImpl();

    @Override
    public User findUserByName(User user) {

        User u = null;

        u = userDao.findUserByName(user);
        return u;
    }
}
