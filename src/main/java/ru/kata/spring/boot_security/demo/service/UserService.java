package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import java.util.Collection;
import java.util.List;


@Component
public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(int id);

    void delete (int id);

    User findByUserName(String name);

    Collection<? extends GrantedAuthority> grantedAuthorities(Collection<Role> roles);

    void addRole (Role role);

    void addDefaultRole ();
}