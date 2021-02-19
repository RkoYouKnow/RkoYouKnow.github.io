package com.ye.dao.impl;

import com.ye.dao.BaseDao;
import com.ye.dao.OrderItemDao;
import com.ye.pojo.OrderItem;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 10:18
 */
public class OrderItemImp extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) VALUES(?,?,?,?,?)";

        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());

    }
}
