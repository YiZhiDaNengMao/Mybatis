package com.star.dao;


import com.star.bean.Orders;

import java.util.List;

/* 与订单表相关 */
public interface OrderMapper {
    /* 一对一查询: 查询所有订单,并且查询出来每个订单的用户信息 */
    List<Orders> findAllOrders();

    List<Orders> findAllOrder();

//    List<Orders> findByUid(int id);

}
