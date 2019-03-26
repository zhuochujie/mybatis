package com.xiaoz.dao;

import com.xiaoz.model.User;

public interface UserDao {
    void save(User user);

    User findUserById(int id);
}
