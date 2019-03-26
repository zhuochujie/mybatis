package com.xiaoz.test;

import com.xiaoz.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo04 {
    private SqlSession session;
    @Before
    public void before() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        session = sessionFactory.openSession();
    }

    @After
    public void after(){
        session.close();
    }
    //插入数据
    @Test
    public void test() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        System.out.println(userMapper.getClass());
        //获取数据
        System.out.println(userMapper.findUserById(1));
        //保存
//        User user = new User("小鸡吧","男",new Date(),"月球");
//        userMapper.save(user);
        session.commit();
    }
}
