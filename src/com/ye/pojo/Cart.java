package com.ye.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车对象
 *
 * @author YeWenHong
 * @explain
 * @create 2021-02-14 18:42
 */
public class Cart {

    //这两个变量没意义
//    private  Integer totalCount;//总商品数
//    private BigDecimal totalPrice;//商品总价格
    private Map<Integer,CartItem> items = new HashMap<>();//购物车商品


    /**
     *
     * @param cartItem
     */
    public void addItems(CartItem cartItem){
        //看看购物车有没有这个商品
        CartItem itemobj = items.get(cartItem.getId());

        if (itemobj==null){//没有这个商品

            items.put(cartItem.getId(),cartItem);

        }else {//购物车有这个商品了

            //数量累加
            itemobj.setCount(itemobj.getCount()+1);
            //更新总金额
            itemobj.setTotalPrice(itemobj.getPrice().multiply(new BigDecimal(itemobj.getCount())));

        }
    }

    /**
     * 根据商品得id删除商品
     * @param id
     */
    public void deleteItems(int id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){
        this.items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(int id,int count){

        CartItem cartItem = items.get(id);

        //说明购物车有该商品
        if (cartItem!=null) {
            //更新商品数量
            cartItem.setCount(count);
            //更新总金额
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }



    }


























    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {

        Collection<CartItem> cartItems = items.values();

        Integer totalCount = 0;

        for (CartItem c:cartItems
             ) {
            totalCount+=c.getCount();
        }

        return totalCount;


    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        Collection<CartItem> cartItems = items.values();

        for (CartItem c:cartItems
             ) {
            totalPrice = totalPrice.add(c.getTotalPrice());
        }

        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
