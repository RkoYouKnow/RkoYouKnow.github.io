package com.ye.web;

import com.ye.dao.BaseDao;
import com.ye.pojo.Cart;
import com.ye.pojo.Order;
import com.ye.pojo.User;
import com.ye.service.OrderService;
import com.ye.service.UserService;
import com.ye.service.impl.OrderServiceImp;
import com.ye.service.impl.UserServiceImp;
import com.ye.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 11:37
 */
public class OrderServlet extends BaseServlet {
    private UserService userService = new UserServiceImp();

    private OrderService orderService = new OrderServiceImp();

    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了createOrder方法");

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        User user = (User)request.getSession().getAttribute("user");
        if (user==null){ //如果没有登录就跳到登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }
//
        User loginUser = userService.login(user);



        String orderId = null;



            orderId = orderService.create(cart, loginUser.getId());




        request.getSession().setAttribute("orderId",orderId);

        //有bug
//        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);

        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");

    }

}
