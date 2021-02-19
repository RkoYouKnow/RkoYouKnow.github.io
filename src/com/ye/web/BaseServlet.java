package com.ye.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 16:01
 */

public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解决post请求中文乱码问题
        //一定要在获取请求参数之前调用才有效
        request.setCharacterEncoding("UTF-8");

        //解决响应中文乱码
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        try {
            System.out.println("action="+action);
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this,request,response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
