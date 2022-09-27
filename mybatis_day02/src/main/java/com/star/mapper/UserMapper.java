package com.star.dao;

import com.star.bean.ResultMapUser;
import com.star.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> findUser(String name);
    List<ResultMapUser> findResultMapUser(int id);

    ResultMapUser findByIdAndName1(int id, String name);

    User findByIdAndName2(int id, String name);
    User findByIdAndName3(
            @Param("id") int _id,
            @Param("name") String _name);
    User findByIdAndName4(User user);

    List<User> findByIdOrName(User user);

    List<ResultMapUser> findByName1(String name);

    List<ResultMapUser> findByName2(String name);

    List<User> findById(List<Integer> list);

    List<User> findById02(int[] array);

    List<User> findAllResultMap();

    void insert(User user);

    void update(User user);
}
