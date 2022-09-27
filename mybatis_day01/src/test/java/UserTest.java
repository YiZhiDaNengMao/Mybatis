import com.star.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    public SqlSession getSqlSession() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        //设置自动提交事务
        return ssf.openSession(true);
    }

    @Test
    public void test01() throws IOException {
        SqlSession sqlSession = getSqlSession();
        List<User> users = sqlSession.selectList("findAll");
        for(User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void test02() throws IOException {
        SqlSession sqlSession = getSqlSession();
        //数据库的增删改操作要手动提交事务
//        sqlSession.commit();
        User user = new User("猪霸天", 8);
        int isInsert = sqlSession.insert("insert", user);
        if(isInsert == 0) {
            System.out.println("insert failed !");
        } else {
            System.out.println("insert success !");
        }
        sqlSession.close();
    }

    @Test
    public void test03() throws IOException {
        SqlSession sqlSession = getSqlSession();
        User user = new User("猪霸天", 8);
        int isDelete = sqlSession.delete("delete", user);
        if(isDelete == 0) {
            System.out.println("delete failed !");
        } else {
            System.out.println("delete success !");
        }
        sqlSession.close();
    }

    @Test
    public void test04() throws IOException {
        SqlSession sqlSession = getSqlSession();
        User user = new User("猪霸天", 6);
        int isDelete = sqlSession.update("update", user);
        if(isDelete == 0) {
            System.out.println("update failed !");
        } else {
            System.out.println("update success !");
        }
        sqlSession.close();
    }

}
