package ru.twf.services;

import ru.twf.domain.User;
import ru.twf.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserDTOById(Long id);

    User getUserById(Long id);

    List<UserDTO> getUserDTOs();

    UserDTO saveUserDTO(UserDTO user);

    void deleteById(Long id);
}
