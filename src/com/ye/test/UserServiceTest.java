package com.ye.test;

import com.ye.pojo.User;
import com.ye.service.UserService;
import com.ye.service.impl.UserServiceImp;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-08 19:16
 */
public class UserServiceTest {

    UserService userService = new UserServiceImp();

    @Test
    public void registUser() {


        userService.registUser(new User(null,"E","afjklsd","753159@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"y2e","123456","ywywy")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("ywe")){
            System.out.println("用户名已存在");
        } else{
            System.out.println("用户名可用");
        }

    }
}