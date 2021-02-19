package com.ye.service;

import com.ye.pojo.User;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-08 19:02
 */
public interface UserService {

    /**
     *      注册用户
     * @param user
     */
    public void registUser(User user);


    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值是登录成功
     */
    public User login(User user);


    /**
     * 检查用户名是否可用
     * @param username
     * @return
     */
    public boolean existsUsername(String username);



}
