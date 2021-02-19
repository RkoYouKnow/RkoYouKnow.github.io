package com.ye.service.impl;

import com.ye.dao.UserDao;
import com.ye.dao.impl.UserDaoImp;
import com.ye.pojo.User;
import com.ye.service.UserService;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-08 19:18
 */
public class UserServiceImp implements UserService {

    private UserDao userDao =  new UserDaoImp();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            //不存在
            return false;
        }
        return true;
    }
}
