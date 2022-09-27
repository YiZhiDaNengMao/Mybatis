package com.star.test;


import com.star.bean.Orders;
import com.star.dao.OrderMapper;
import com.star.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* 测试类*/
public class OrderTest {
    //一对一
    @Test
    public void test01() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        OrderMapper mapper = ss.getMapper(OrderMapper.class);

        List<Orders> orders = mapper.findAllOrders();
        for (Orders o :orders) {
            System.out.println(o);
        }

        ss.close();
    }

    //一对一嵌套查询
    @Test
    public void test03() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession ss = ssf.openSession(true);
        OrderMapper mapper = ss.getMapper(OrderMapper.class);

        List<Orders> orders = mapper.findAllOrder();
        for (Orders o :orders) {
            System.out.println(o);
        }

        ss.close();
    }

}





