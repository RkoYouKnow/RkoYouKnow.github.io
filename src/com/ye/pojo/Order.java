package com.ye.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author YeWenHong
 * @explain
 * @create 2021-02-15 9:37
 */
public class Order {
    private String orderid;
    private Date createTime;
    private BigDecimal price;
    //0未发货，1已发货，2，已签收
    private Integer status = 0;
    private Integer userId;


    public Order() {
    }

    public Order(String orderid, Date createTime, BigDecimal price, Integer status, Integer userId) {
        this.orderid = orderid;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }


    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
