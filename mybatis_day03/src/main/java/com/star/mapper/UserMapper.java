package com.star.dao;

import com.star.bean.User;

import java.util.List;

/* 和User表相关的CRUD */
public interface UserMapper {
    /*一对多查询: 查询所有用户,以及同时查询该用户所拥有的订单 */
    List<User> findAllUser();

    List<User> findAllRole();

    User findById(int id);

    List<User> findAllUsers();

    List<User> findAllRole2();

}








