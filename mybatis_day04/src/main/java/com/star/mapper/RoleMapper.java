package com.star.mapper;

import com.star.bean.Role;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleMapper {

    @Select("select * from sys_role")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userList", javaType = List.class, column = "id",
                    one = @One(
                            select = "com.star.mapper.UserMapper.findById",
                            fetchType = FetchType.EAGER
                    ))
    })

    List<Role> findAllUser();
}
