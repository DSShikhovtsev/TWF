package ru.twf.services;

import ru.twf.domain.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    List<User> getUsers();
    User save(User user);
    void delete(User user);
    void deleteById(Long id);
}
