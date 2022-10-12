package com.pzx.service;

import com.pzx.pojo.Cart;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: gfk
 * @create: 2022/10/11
 * @Description:
 * @FileName: OrderService
 * @History:
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
