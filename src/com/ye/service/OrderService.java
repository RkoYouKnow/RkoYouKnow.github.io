package com.ye.service;

import com.ye.pojo.Cart;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 10:54
 */
public interface OrderService {

    public String create(Cart cart,int userId);

}
