package com.star.test;
import com.star.bean.User;
import com.star.dao.RoleMapper;
import com.star.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    //一对多
    @Test
    public void test01() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        List<User> users = mapper.findAllUser();
        for (User u : users) {
            System.out.println(u);
        }

        ss.close();
    }

    //多对多
    @Test
    public void test02() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        List<User> users = mapper.findAllRole();
        for (User u : users) {
            System.out.println(u);
        }

        ss.close();
    }

    //嵌套 一对多
    @Test
    public void test03() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        List<User> users = mapper.findAllUsers();
        for (User u : users) {
            System.out.println(u);
        }

        ss.close();
    }

    //嵌套 多对多
    @Test
    public void test04() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        List<User> users = mapper.findAllRole2();
        for (User u : users) {
            System.out.println(u);
        }

        ss.close();
    }

    //Mybatis 缓存
    @Test
    public void test05() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        User user1 = mapper.findById(1);
        System.out.println(user1);

        User user2 = mapper.findById(1);
        System.out.println(user2);

        ss.close();
    }

}
