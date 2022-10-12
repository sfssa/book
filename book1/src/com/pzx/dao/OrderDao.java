package com.pzx.dao;

import com.pzx.pojo.Order;

/**
 * @author: gfk
 * @create: 2022/10/11
 * @Description:
 * @FileName: OrderDao
 * @History:
 */
public interface OrderDao {
    public int saveOrder(Order order);
}
