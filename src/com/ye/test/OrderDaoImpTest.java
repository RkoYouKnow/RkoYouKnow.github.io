package com.ye.test;

import com.ye.dao.OrderDao;
import com.ye.dao.impl.OrderDaoImp;
import com.ye.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 10:32
 */
public class OrderDaoImpTest {

    @Test
    public void saveOrder() {

        OrderDao orderDao = new OrderDaoImp();

        Order order = new Order();
        order.setUserId(65);
        order.setOrderid("002");

        System.out.println(orderDao.saveOrder(order));


    }
}