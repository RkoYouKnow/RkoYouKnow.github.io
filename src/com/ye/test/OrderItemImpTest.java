package com.ye.test;

import com.ye.dao.impl.OrderItemImp;
import com.ye.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 10:28
 */
public class OrderItemImpTest {

    @Test
    public void saveOrderItem() {

        OrderItemImp orderItemImp = new OrderItemImp();
        OrderItem orderItem = new OrderItem(null,"java编程思想",3,new BigDecimal(60),new BigDecimal(180),"001");
        orderItemImp.saveOrderItem(orderItem);


    }
}