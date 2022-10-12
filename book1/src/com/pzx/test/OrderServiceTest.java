package com.pzx.test;

import com.pzx.pojo.Cart;
import com.pzx.pojo.CartItem;
import com.pzx.service.OrderService;
import com.pzx.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构和算法",1,new BigDecimal(100),new BigDecimal(100)));
        OrderService orderService=new OrderServiceImpl();
        System.out.println("订单号："+orderService.createOrder(cart,1));
    }
}