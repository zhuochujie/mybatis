package com.xiaoz.test;

import com.xiaoz.mapper.UserMapper;
import com.xiaoz.model.User;
import com.xiaoz.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo05 {
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
        UserQueryVO query = new UserQueryVO();
        User user = new User();
        user.setId(1);
        query.setUser(user);
        List<User> list = userMapper.findUserByUserQueryVO(query);
        System.out.println(list);
    }
    @Test
    public void test2() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","张");
        map.put("sex",1);
        List<User> list = userMapper.findUserByMap(map);
        System.out.println(list);
    }
}
