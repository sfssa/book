package com.pzx.test;

import com.pzx.dao.OrderItemDao;
import com.pzx.dao.impl.OrderItemDaoImpl;
import com.pzx.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"Java从入门到精通",1,new BigDecimal(53),new BigDecimal(100),"1234567"));
    }
}