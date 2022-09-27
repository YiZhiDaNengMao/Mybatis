package com.star.mapper;

import com.star.bean.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{uid}")
    User findByUid();


    @Select("select * from user")
    @Result(
            property = "ordersList", javaType = List.class, column = "id",
            one = @One(
                    select = "com.star.mapper.OrderMapper.findByUid",
                    fetchType = FetchType.EAGER
            )
    )
    List<User> findOrders();

    @Select("select * from user u join sys_user_role ur on u.id = ur.userid where ur.roleid = #{rid}")
    List<User> findById();

}
