package com.ye.dao.impl;

import com.ye.dao.BaseDao;
import com.ye.dao.OrderDao;
import com.ye.pojo.Order;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 10:01
 */
public class OrderDaoImp extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {

        String sql = "INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) VALUES(?,?,?,?,?)";

        return update(sql,order.getOrderid(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }
}
