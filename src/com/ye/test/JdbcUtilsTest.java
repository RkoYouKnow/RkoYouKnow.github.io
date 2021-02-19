package com.ye.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ye.dao.impl.UserDaoImp;
import com.ye.pojo.User;
import com.ye.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-06 18:08
 */
public class JdbcUtilsTest {


//    /**
//     *测试数据库连接池
//     */
//    @Test
//    public void testJdbcUtils(){
//        for (int i = 0; i < 100; i++) {
//            Connection connection = JdbcUtils.getConnection();
//            System.out.println(connection);
//            JdbcUtils.close(connection);
//        }
//    }
//
//    @Test
//    public void update(){
//        Connection conn = null;
//
//        try {
//            QueryRunner queryRunner = new QueryRunner();
//            conn = JdbcUtils.getConnection();
//            String sql = "INSERT INTO t_user(`username`,`password`,`email`) VALUES (?,?,?);";
//
//            int num = queryRunner.update(conn, sql, "12", "123456", "31546543@qq.com");
//            System.out.println(num);
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }finally {
//            JdbcUtils.close(conn);
//        }
//
//
//    }
//
//
//
//    /**
//     * 测试查询操作
//     */
//    @Test
//    public void querytest(){
//
//        Connection connection=null;
//
//        try {
//
//            connection = JdbcUtils.getConnection();
//
//            QueryRunner queryRunner = new QueryRunner();
//
//            String sql = "SELECT COUNT(*) FROM `t_user`;";
//
//            ScalarHandler handler = new ScalarHandler();
//
//            Long num = (Long) queryRunner.query(connection, sql, handler);
//
//            System.out.println(num);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        finally {
//            JdbcUtils.close(connection);
//        }
//
//
//
//    }

    /**
     * 测试userdaoimp
     */
    @Test
    public void testImp(){

        UserDaoImp userDaoImp = new UserDaoImp();

        User ye = userDaoImp.queryUserByUsername("ye");
        System.out.println(ye);

        User ye1 = userDaoImp.queryUserByUsernameAndPassword("ye", "123456");
        System.out.println(ye1);

        User user = new User();
        user.setUsername("b王");
        user.setPassword("qwert");
        user.setEmail("13245678@qq.com");

        int i = userDaoImp.saveUser(user);
        System.out.println(i);
    }


}
