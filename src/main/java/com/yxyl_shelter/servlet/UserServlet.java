package com.yxyl_shelter.servlet;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yxyl_shelter.domain.Info;
import com.yxyl_shelter.domain.User;
import com.yxyl_shelter.service.UserService;
import com.yxyl_shelter.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
        System.out.println(u.toString());

        //response results to foreground client(前台客户端)
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);


    }


    /**
     * 注册功能
     * @param req
     * @param resp
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //get values
        Map<String, String[]> map = req.getParameterMap();
        //encapsulated object
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean flag = userService.register(user);
        Info info = new Info();

        if (flag){
            //成功
            info.setFlag(true);
        }else {
            //失败
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }

        //序列化json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);







    }


}
