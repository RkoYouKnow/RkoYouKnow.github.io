package com.ye.filter;

import com.ye.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 16:23
 */
public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        User user =(User) request.getSession().getAttribute("user");

        if (user==null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }else {
            chain.doFilter(req, resp);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
