package com.xiaoz.test;

import com.xiaoz.dao.UserDao;
import com.xiaoz.dao.UserDaoImpl;
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

public class Demo03 {
    SqlSession session;
    SqlSessionFactory sessionFactory;
    @Before
    public void before() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
    //插入数据
    @Test
    public void test() throws IOException {
        //调用dao
        //1.创建dao
        UserDao userDao = new UserDaoImpl(sessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
        User user1 = new User("周卓","男",new Date(), "长沙");
        userDao.save(user1);
        System.out.println(user1);
    }
}
