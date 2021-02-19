package com.ye.dao;

import com.ye.pojo.OrderItem;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 9:59
 */
public interface OrderItemDao {

    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);

}
