package com.oschepich.spring_mvc_hibernate.dao;

import com.oschepich.spring_mvc_hibernate.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


// метод передачи всего списка пользователей
    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> list = query.getResultList();
        return list;
    }
// метод обновления и добавления пользователя
    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

//    метод обновления пользователя (пригодится на потом - пока не используется)
    @Override
    public void updateUser(int id, User user) {
//        User updateUser = entityManager.find(User.class, user.getId());;
//        updateUser.setName(user.getName());
//        updateUser.setAddress(user.getAddress());
//        updateUser.setEmail(user.getEmail());
        entityManager.merge(user);
    }
// метод нахождения одного пользователя
    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }
// метод удаления пользователя
    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}