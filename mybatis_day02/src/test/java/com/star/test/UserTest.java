package com.star.test;


import com.star.bean.ResultMapUser;
import com.star.bean.User;
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

    @Test
    public void test01() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);

        UserMapper mapper = ss.getMapper(UserMapper.class);
        List<User> users = mapper.findUser("猪皮怪");
        for(User u : users) {
            System.out.println(u);
        }
        ss.close();
    }

    //ResultMap使用
    @Test
    public void test02() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);

        UserMapper mapper = ss.getMapper(UserMapper.class);
        List<ResultMapUser> users = mapper.findResultMapUser(1);
        for(ResultMapUser u : users) {
            System.out.println(u);
        }
        ss.close();
    }

    //多条件查询的两种方式
    @Test
    public void test03() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);
        //方式一
        //{arg0} {arg1} ...
        ResultMapUser resultMapUser = mapper.findByIdAndName1(1,"派大星");
        System.out.println(resultMapUser);
        //{param1} {param2} ...
        User user1 = mapper.findByIdAndName2(3, "猪皮怪");
        System.out.println(user1);

        //方式二：使用注解，引入 @Param()注解获取参数-
        User user2 = mapper.findByIdAndName3(4, "猪霸天");
        System.out.println(user2);

        //方式三：使用pojo传递参数
        User user3 = mapper.findByIdAndName4(
                new User(4,"猪霸天", 5));
        System.out.println(user3);

        ss.close();
    }

    @Test
    public void test04() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);
        //模糊查询
        //方式一：
        List<ResultMapUser> users1 = mapper.findByName1("%猪霸天%");
        for(ResultMapUser u : users1) {
            System.out.println(u);
        }

        //方式二：
        List<ResultMapUser> users2 = mapper.findByName2("%猪霸天%");
        for(ResultMapUser u : users2) {
            System.out.println(u);
        }
    }

}
