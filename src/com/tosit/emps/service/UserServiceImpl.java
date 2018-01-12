package com.tosit.emps.service;

import com.tosit.emps.dao.UserDao;
import com.tosit.emps.dao.UserDaoImpl;
import com.tosit.emps.entity.User;

public class UserServiceImpl implements UserService {
    //服务层 注入 dao 层
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User findUserByName(String name) {
        return userDao.selectUserByName(name);
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }

}
