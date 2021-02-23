package com.oschepich.spring_mvc_hibernate.service;

import com.oschepich.spring_mvc_hibernate.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();

    public void saveUser(User user);

    public void updateUser(int id, User user);

    public User show(int id);

    public void deleteUser(int id);
}
