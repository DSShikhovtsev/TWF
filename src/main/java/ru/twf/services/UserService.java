package ru.twf.services;

import ru.twf.domain.User;

import java.util.List;

public interface UserService {

    User getUser();
    List<User> getUsers();
}
