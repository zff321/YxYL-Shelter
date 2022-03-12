package com.yxyl_shelter.servlet;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.yxyl_shelter.domain.User;
import com.yxyl_shelter.service.UserService;
import com.yxyl_shelter.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


}
