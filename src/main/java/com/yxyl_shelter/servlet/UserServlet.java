package com.yxyl_shelter.servlet;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.yxyl_shelter.domain.Info;
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

    /**
     * 登录功能
     *
     * @param request
     * @param response
     * @throws JsonProcessingException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

        Map<String, String[]> map = request.getParameterMap();

        User user = new User();

        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        User u = userService.findUserByName(user);
        //创建信息传递对象
        Info info = new Info();

        if (u == null) {
            //改用户名不存在
            info.setFlag(false);
            info.setErrorMsg("账号或密码Error");
        } else {
            //用户名存在
            //登录
            info.setFlag(true);
            request.getSession().setAttribute("user", u);
        }
    }


}
