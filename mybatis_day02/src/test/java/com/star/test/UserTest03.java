package com.star.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.star.bean.User;
import com.star.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserTest03 {
    @Test
    public void test() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        User user = new User();
        user.setName("魑魅");
        List<User> users = mapper.findByIdOrName(user);
        for (User u : users) {
            System.out.println(u);
        }
    }
    @Test
    public void test02() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        User user = new User(1,"魑魅魍魉",7);
        mapper.update(user);
    }

    @Test
    public void test03() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<User> users = mapper.findById(list);*/

        int[] ids = {1, 2, 3};
        List<User> users = mapper.findById02(ids);
        for(User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void test04() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        PageHelper.startPage(2, 2);

        List<User> users = mapper.findAllResultMap();
        for(User u : users) {
            System.out.println(u);
        }

        //3.获取分页相关的其他参数值:
        PageInfo<User> pageInfo = new PageInfo<>(users);
        //总条数
        System.out.println("总条数:" + pageInfo.getTotal());
        //总页数
        System.out.println("总页数:" + pageInfo.getPages());
        //当前页
        System.out.println("当前页:" + pageInfo.getPageNum());
        //每页条数
        System.out.println("每页条数:" + pageInfo.getPageSize());
        //是否是第一页
        System.out.println("是否是第一页:" + pageInfo.isIsFirstPage());
        //是否是最后一页
        System.out.println("是否是最后一页:" + pageInfo.isIsLastPage());

    }



}
