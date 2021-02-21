package com.oschepich.spring_mvc_hibernate.dao;

import com.oschepich.spring_mvc_hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private final EntityManagerFactory entityManager;

    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    //    private List<User> userList;

    //    создаю список машин
//    {
//        userList = new ArrayList<>();
//        userList.add(new User("Иван Петров", "г. Петровск", "1975Ivan@mail.ru"));
//        userList.add(new User("Петр Иванов", "г. Ивановск", "1970Petr@mail.ru"));
//        userList.add(new User("Иван Иванов", "г. Петровск на азове", "1980IVAN@mail.ru"));
//        userList.add(new User("Петр Петров", "г. Иваново", "1990Petr@mail.ru"));
//        userList.add(new User("Иван Петров-Иванов", "г. Петрово", "1999IVAN@mail.ru"));
//    }
// метод передачи списка машин
    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createEntityManager().createQuery("from User", User.class);
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public void saveUser(User user) {
        User userSave = new User();
        entityManager.createEntityManager().merge(user);
        user.setId(userSave.getId());

    }

    @Override
    public void updateUser(User user) {

    }
}