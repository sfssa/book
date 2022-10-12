package com.pzx.dao;

import com.pzx.pojo.Order;
import com.pzx.pojo.OrderItem;

/**
 * @author: gfk
 * @create: 2022/10/11
 * @Description:
 * @FileName: OrderItemDao
 * @History:
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
}
