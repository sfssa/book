package com.pzx.dao.impl;

import com.pzx.dao.OrderItemDao;
import com.pzx.pojo.OrderItem;

/**
 * @author panzhixin
 * @date 2022/10/11
 * @description
 */

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());

    }
}