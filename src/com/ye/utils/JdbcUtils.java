package com.ye.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-06 17:54
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {

        try {
            Properties properties = new Properties();

            //读取jdbc配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //从流中加载数据
            properties.load(inputStream);

            //创建数据库连接池
            dataSource=(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null，说明获取连接失败
     */
    public static Connection getConnection(){

        Connection connection = threadLocal.get();
        if (connection==null){

            try {
                connection = dataSource.getConnection();//从数据库连接池中获取连接
                threadLocal.set(connection); //保存到ThreadLocal对象中
                connection.setAutoCommit(false);//设置为手动提交事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return connection;

//        Connection conn = null;
//
//        try {
//            conn=dataSource.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return conn;


    }

    /**
     * 提交事务，并关闭释放资源
     */
    public static void commitAndClose(){
        Connection connection = threadLocal.get();

        if (connection!=null){
            try {
                connection.commit();//提交事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        threadLocal.remove();


    }

    public static void rollbackAndClose(){

        Connection connection = threadLocal.get();

        if (connection!=null){

            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        threadLocal.remove();
    }


//    /**
//     * 关闭连接
//     * @param conn
//     */
//    public static void close(Connection conn){
//        if (conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//    }

}
