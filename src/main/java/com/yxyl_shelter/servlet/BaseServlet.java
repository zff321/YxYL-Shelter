package com.yxyl_shelter.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

    public class BaseServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //完成方法的分发
            String uri = req.getRequestURI();
            //获取路径名称
            String methodName = uri.substring(uri.lastIndexOf("/") + 1);
            try {
                //获取方法对象
                Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                //执行方法
                //暴力反射(不太好)
                //method.setAccessible(true);
                method.invoke(this, req, resp);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        /**
         * 直接将传入的对象序列化json，传回客户端
         *
         * @param obj
         */
        public void writeValue(Object obj, HttpServletResponse response) throws IOException {
            //Serialization json and  return
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), obj);
        }

        /**
         * 将传入的对象序列化为json，返回给调用者
         *
         * @param obj
         * @return
         */
        public String writeValueAsString(Object obj) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        }
    }


