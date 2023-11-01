package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUsers();

    void addUser (User user);

    User getUserById(int id);
    void delete (int id);

    User getUserByName(String name);

    void addRole (Role role);
}