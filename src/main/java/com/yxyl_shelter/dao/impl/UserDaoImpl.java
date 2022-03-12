package com.yxyl_shelter.dao.impl;

import com.yxyl_shelter.dao.UserDao;
import com.yxyl_shelter.domain.User;
import com.yxyl_shelter.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserByName(User user) {

        jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user);
    }
}
