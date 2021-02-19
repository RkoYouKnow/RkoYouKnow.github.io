package com.ye.test;

import com.ye.pojo.Cart;
import com.ye.pojo.CartItem;
import com.ye.service.OrderService;
import com.ye.service.impl.OrderServiceImp;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 11:32
 */
public class OrderServiceTest {

    @Test
    public void create() {
        OrderService orderService = new OrderServiceImp();

        Cart cart = new Cart();
        cart.addItems(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000))); cart.addItems(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000))); cart.addItems(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

        System.out.println(orderService.create(cart, 1));

        System.out.println(cart);

    }
}