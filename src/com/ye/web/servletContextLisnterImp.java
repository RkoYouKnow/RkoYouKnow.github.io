package com.ye.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-09 22:43
 */
@Deprecated
public class servletContextLisnterImp implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener创建");
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener销毁");
    }
}
