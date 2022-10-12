package com.pzx.dao.impl;

import com.pzx.dao.OrderDao;
import com.pzx.pojo.Order;

/**
 * @author panzhixin
 * @date 2022/10/11
 * @description
 */

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }
}