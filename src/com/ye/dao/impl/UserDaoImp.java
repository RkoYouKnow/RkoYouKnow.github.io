package com.ye.dao.impl;

import com.ye.dao.BaseDao;
import com.ye.dao.UserDao;
import com.ye.pojo.User;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-08 17:23
 */
public class UserDaoImp extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {

        String sql = "SELECT `id`,`username`,`password`,`email` FROM `t_user` WHERE username = ?;";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM `t_user` WHERE username = ? AND `password` = ?;";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        Integer id = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();

        String sql = "INSERT INTO t_user(`username`,`password`,`email`) VALUES (?,?,?);";

        return update(sql,username,password,email);
    }
}
