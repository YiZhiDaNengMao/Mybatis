package com.star.test;

import com.star.bean.User;
import com.star.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserTest02 {
    @Test
    public void test() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        UserMapper mapper = ss.getMapper(UserMapper.class);

        User user = new User("魑魅", 17);
        System.out.println(user);
        mapper.insert(user);
        System.out.println(user);
        ss.close();

    }
}
