package com.ye.web;

import com.ye.pojo.User;
import com.ye.service.UserService;
import com.ye.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-08 21:26
 */
@Deprecated
public class RegisterServlet extends HttpServlet {

    UserService userService = new UserServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String text = request.getParameter("text");
        String code = request.getParameter("code");

        //判断验证码正不正确
        if ("abcde".equals(code)){ //验证码正确

            //判断用户名可不可以用
            if (userService.existsUsername(username)){//不可用
                request.setAttribute("msg","用户名已存在");
                System.out.println("用户名"+username+"已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {//可用
                User user = new User(null, username, password, text);
                userService.registUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);

            }

        }else {//验证码错误
            request.setAttribute("username","hhh");
            request.setAttribute("password",password);
            request.setAttribute("text",text);
            request.setAttribute("msg","验证码错误");
            System.out.println("验证码"+code+"错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
