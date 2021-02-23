package com.oschepich.spring_mvc_hibernate.dao;

import com.oschepich.spring_mvc_hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


// метод передачи списка машин
    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User updateUser = entityManager.find(User.class, user.getId());;
        user.setName(updateUser.getName());
        user.setAddress(updateUser.getAddress());
        user.setEmail(updateUser.getEmail());
        entityManager.merge(user);
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}