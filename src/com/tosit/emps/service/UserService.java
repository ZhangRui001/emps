package com.tosit.emps.service;

import com.tosit.emps.entity.User;

public interface UserService {
    public User findUserByName(String name);
    public void addUser(User user);
}
