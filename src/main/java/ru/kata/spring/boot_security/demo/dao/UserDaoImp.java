package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers () {
        String jpql = "SELECT e FROM User e";
        List<User> users = entityManager.createQuery(jpql, User.class).getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        if (user.getId() != 0) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void delete(int id) {
        User userDelete = entityManager.find(User.class, id);
        entityManager.remove(userDelete);
    }

    @Override
    public User getUserByName(String name) {
        User user = entityManager.find(User.class, name);
        return user;
    }
    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }
}
