package com.xiaoz.test;

import com.xiaoz.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Demo02 {
    SqlSession session;
    @Before
    public void before() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //通过SqlSessionFactory创建SqlSession
        session = sessionFactory.openSession();
    }
    @After
    public void after(){
        //关闭Session
        session.close();
    }

    //插入数据
    @Test
    public void test() throws IOException {
        User user = new User("xiaoZ6", "1", new Date(), "张家界");
        session.insert("insertUser", user);
        session.commit();
    }

    //删除数据
    @Test
    public void test2() throws IOException {
        session.delete("deleteUser", 31);
        session.commit();
    }

    //更新数据
    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setId(29);
        user.setSex("男");
        user.setAddress("湖南");
        int row = session.update("updateUser", user);
        session.commit();
        System.out.println(row);
    }

    //插入后,往模型返回id(主键)
    @Test
    public void tes4() throws IOException {
        User user = new User("xiaoZ", "1", new Date(), "张家界");
        session.insert("insertUser2", user);
        session.commit();
        System.out.println("id:"+user.getId());
    }
}
