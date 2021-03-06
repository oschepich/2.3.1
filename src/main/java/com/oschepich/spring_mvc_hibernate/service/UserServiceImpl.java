package com.oschepich.spring_mvc_hibernate.service;

import com.oschepich.spring_mvc_hibernate.dao.UserDao;
import com.oschepich.spring_mvc_hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


//  метод передачи всего списка user-ов
    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

 //  метод добавления одного user-а в списка
    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    //    метод обновления пользователя (пригодится на потом - пока не используется)
    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id,user);
    }

    //  метод изменения одного user-а в списка
    @Override
    @Transactional
    public User show(int id) {
        return userDao.show(id);
    }

    //  метод удаления одного user-а из списка
    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
