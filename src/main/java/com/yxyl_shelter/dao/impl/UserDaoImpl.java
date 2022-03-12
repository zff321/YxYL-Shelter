package com.yxyl_shelter.dao.impl;

import com.yxyl_shelter.dao.UserDao;
import com.yxyl_shelter.domain.User;
import com.yxyl_shelter.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public User findUserByUsernameAndPassword(String u_username, String u_password) {
        User user = null;

        try {
            String sql = "select * from user where u_username = ? and u_password = ? ";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), u_username, u_password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        User user = null;

        try {
            String sql = "select * from user where u_username = ?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
        }

        return user;
    }

    @Override
    public void save(User u) {
        String sql = "insert user" +
                "(u_id," +
                "u_username," +
                "u_password," +
                "u_gender," +
                "u_address," +
                "u_tele," +
                "u_email) values (null,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,u.getU_username(),u.getU_password(),u.getU_gender(),u.getU_address(),u.getU_tele(),u.getU_email());
    }
}
