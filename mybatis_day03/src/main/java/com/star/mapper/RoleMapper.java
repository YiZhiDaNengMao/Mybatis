package com.star.dao;

import com.star.bean.User;

import java.util.List;

public interface RoleMapper {
    List<User> selectByUid(int id);

}
