package ru.twf.services;

import ru.twf.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserById(Long id);
    List<UserDTO> getUsers();
    UserDTO save(UserDTO user);
    void deleteById(Long id);
}
