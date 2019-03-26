package com.xiaoz.test;

import com.xiaoz.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo01 {
    @Test
    public void test1() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //通过SqlSessionFactory创建SqlSession
        SqlSession session = sessionFactory.openSession();
        //调用SqlSession操作数据库方法
        User user = session.selectOne("findUserById", 10);
        System.out.println(user);

        List<User> users = session.selectList("findUserByName", "张");
        System.out.println(users);
        //关闭Session
        session.commit();
    }
}
