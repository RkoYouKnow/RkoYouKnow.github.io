package com.ye.dao;

import com.ye.pojo.Order;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 9:58
 */
public interface OrderDao {

    /**
     * 保存订单
     * @param order
     * @return
     */
    public int saveOrder(Order order);




}
