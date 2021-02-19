package com.ye.web;

import com.google.gson.Gson;
import com.ye.pojo.User;
import com.ye.service.UserService;
import com.ye.service.impl.UserServiceImp;
import com.ye.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 用户模块
 *
 * @author YeWenHong
 * @explain
 * @create 2021-02-11 15:39
 */
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImp();

    public void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("ajaxExistsUsername方法被调用了");

        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);

        HashMap<String, Boolean> hashMap = new HashMap<>();

        hashMap.put(username,existsUsername);

        Gson gson = new Gson();

        String toJson = gson.toJson(hashMap);

        resp.getWriter().write(toJson);


    }



    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(null,username,password,"");
        //判断用户名是否可用
        if (userService.existsUsername(username)){

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

    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InterruptedException {

        String attribute = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.removeAttribute(KAPTCHA_SESSION_KEY);




        //获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String text = request.getParameter("text");
        String code = request.getParameter("code");

        User user = WebUtils.copyParamToBean(request.getParameterMap(),new User());

        //判断验证码正不正确
        if (attribute!=null&&attribute.equalsIgnoreCase(code)){ //验证码正确

            //判断用户名可不可以用
            if (userService.existsUsername(username)){//不可用
                request.setAttribute("msg","用户名已存在");
                System.out.println("用户名"+username+"已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {//可用
                user = new User(null, username, password, text);
                userService.registUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);

            }

        }else {//验证码错误
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("text",text);
            request.setAttribute("msg","验证码错误");
            System.out.println("验证码"+code+"错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }




    }

    /**
     * 注销用户
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //注销session
        request.getSession().invalidate();

        //重定向到首页
        response.sendRedirect(request.getContextPath());


    }

}
