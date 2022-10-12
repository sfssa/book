package com.pzx.service.impl;

import com.pzx.dao.BookDao;
import com.pzx.dao.OrderDao;
import com.pzx.dao.OrderItemDao;
import com.pzx.dao.impl.BookDaoImpl;
import com.pzx.dao.impl.OrderDaoImpl;
import com.pzx.dao.impl.OrderItemDaoImpl;
import com.pzx.pojo.*;
import com.pzx.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author panzhixin
 * @date 2022/10/11
 * @description
 */

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单地唯一性，购物车+用户id
        String orderId=System.currentTimeMillis()+""+userId;
        //创见一个订单对象
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存菜单
        orderDao.saveOrder(order);
        for(Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
            CartItem cartItem=entry.getValue();
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        return orderId;
    }
}