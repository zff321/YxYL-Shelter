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

        return userDao.findUserByUsernameAndPassword(user.getU_username(), user.getU_password());
    }

    @Override
    public boolean register(User user) {
        //先查找是否存在该用户
        User u = userDao.findUserByUsername(user.getU_username());

        if (u != null) {
            //存在
            //不用保存
            return false;
        } else {
            //不存在
            //保存
            userDao.save(u);
            return true;
        }
    }
}
