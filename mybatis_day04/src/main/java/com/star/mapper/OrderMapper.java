package com.star.mapper;

import com.star.bean.Orders;
import com.star.bean.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderMapper {
    @Select("select * from orders")
    @Result(property = "user", javaType = User.class, column = "uid",
            one = @One(
                    select = "com.star.mapper.UserMapper.findByUid",
                    fetchType = FetchType.EAGER
            ))
    List<Orders> findOrders();

    @Select("select * from orders where uid = #{uid}")
    List<Orders> findByUid(Integer uid);

}
