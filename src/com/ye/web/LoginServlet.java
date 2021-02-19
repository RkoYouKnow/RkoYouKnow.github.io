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
 * @create 2021-02-09 10:11
 */
@Deprecated
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断用户名是否可用
        if (userService.existsUsername(username)){
            User user = new User(null,username,password,"");
            if (userService.login(user)==null){//密码错误
                request.setAttribute("username",username);
                request.setAttribute("msg","密码错误");
                System.out.println("密码"+password+"错误");
                request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            }else {//登录成功
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("msg","用户名不存在");
            System.out.println("用户名"+username+"不存在");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
