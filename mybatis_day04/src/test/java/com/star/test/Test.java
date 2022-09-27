package com.star.test;

import com.star.bean.Orders;
import com.star.bean.Role;
import com.star.bean.User;
import com.star.mapper.OrderMapper;
import com.star.mapper.RoleMapper;
import com.star.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {

    private SqlSessionFactory ssf;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        ssf = new SqlSessionFactoryBuilder().build(is);
        sqlSession = ssf.openSession();
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @org.junit.Test
    public void test1() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findAll();
        for(User u : users) {
            System.out.println(u);
        }

    }

    //一对一
    @org.junit.Test
    public void test2() throws IOException {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> orders = mapper.findOrders();
        for(Orders o : orders) {
            System.out.println(o);
        }

    }

    //一对多
    @org.junit.Test
    public void test3() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findOrders();
        for(User u : users) {
            System.out.println(u);
        }

    }

    //多对多
    @org.junit.Test
    public void test4() throws IOException {
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roles = mapper.findAllUser();
        for(Role r : roles) {
            System.out.println(r);
        }

    }
}
