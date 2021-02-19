package com.ye.service.impl;

import com.ye.dao.BookDao;
import com.ye.dao.OrderDao;
import com.ye.dao.OrderItemDao;
import com.ye.dao.impl.BookDaoImp;
import com.ye.dao.impl.OrderDaoImp;
import com.ye.dao.impl.OrderItemImp;
import com.ye.pojo.*;
import com.ye.service.OrderService;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 10:57
 */
public class OrderServiceImp implements OrderService {



    private OrderDao orderDao = new OrderDaoImp();

    private OrderItemDao orderItemDao = new OrderItemImp();

    private BookDao bookDao = new BookDaoImp();


    @Override
    public String create(Cart cart, int userId) {

        //订单号==唯一
        String orderId = System.currentTimeMillis()+""+userId;

        //保存订单项
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

//        int i = 12/ 0 ;

        //遍历购物车中得每一个商品项转换成订单项保存到数据库

        Map<Integer, CartItem> items = cart.getItems();

        Collection<CartItem> values = items.values();

        for (CartItem c:values
             ) {
            OrderItem orderItem = new OrderItem(null, c.getName(), c.getCount(), c.getPrice(), c.getTotalPrice(), order.getOrderid());
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(c.getId());
            book.setSales(book.getSales()+c.getCount());
            book.setStock(book.getStock()-c.getCount());
            bookDao.updateBook(book);
        }

        //清空购物车
        cart.clear();


        return orderId;
    }
}
