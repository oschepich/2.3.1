package com.oschepich.spring_mvc_hibernate.service;

import com.oschepich.spring_mvc_hibernate.dao.UserDao;
import com.oschepich.spring_mvc_hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    ////    метод селекции списка машин взависимсти от заданных параметров
//    public List<Car> showCars(int count, List<Car> carList) {
//       return carList.stream().limit(count).collect(Collectors.toList());
//    }
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
    //  метод изменения одного user-а в списка

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
