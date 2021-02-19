package com.ye.filter;

import com.ye.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 20:31
 */
public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, resp);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();
            throw new RuntimeException(e);//把异常抛给tomcat服务器
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
