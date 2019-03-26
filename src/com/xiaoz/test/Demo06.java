package com.xiaoz.test;

import com.xiaoz.mapper.OrderMapper;
import com.xiaoz.mapper.UserMapper;
import com.xiaoz.model.Orders;
import com.xiaoz.model.OrdersExt;
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
import java.util.ArrayList;
import java.util.List;

public class Demo06 {
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
        user.setSex("1");//男性
        query.setUser(user);
        int count = userMapper.findUserCount(query);
        System.out.println("男性用户人数"+count);
    }

    @Test
    public void test2() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findUserByIdResultMap(1);
        System.out.println("用户信息"+user);
    }

    @Test
    public void test3() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        UserQueryVO query = new UserQueryVO();
        User user = new User();
        user.setSex("1");
        user.setUsername("张");
        query.setUser(user);
        List<User> users = userMapper.findUserList(query);
        System.out.println(users);
    }

    @Test
    public void test4() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        UserQueryVO query = new UserQueryVO();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        query.setIds(ids);
        List<User> users = userMapper.findUserByIds(query);
        System.out.println(users);
    }

    @Test
    public void test5() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        List<User> users = userMapper.findUserByIds2(ids);
        System.out.println(users);
    }

    /*一对一: 订单拓展类*/
    @Test
    public void test6() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        OrdersExt ordersExt = orderMapper.findOrderById(3);
        System.out.println(ordersExt);
    }

    /*一对一: 模型里面有模型*/
    @Test
    public void test7() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Orders order = orderMapper.findOrderById2(3);
        System.out.println(order);
        System.out.println(order.getUser());
    }

    /*一对多: 模型里有集合*/
    @Test
    public void test8() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Orders order = orderMapper.findOrderById3(3);
        System.out.println(order);
        System.out.println(order.getUser());
        System.out.println(order.getOrderDetails());
    }
}
