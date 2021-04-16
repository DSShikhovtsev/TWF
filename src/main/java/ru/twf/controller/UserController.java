package ru.twf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.twf.dto.UserDTO;
import ru.twf.dto.UserDTO2;
import ru.twf.services.UserService;

import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<UserDTO> getOwn() {
        return userService.getUsers();
    }

    @GetMapping("users2")
    public UserDTO2 getOwn2() {
        UserDTO2 userDTO2 = new UserDTO2();
        userDTO2.setUsers(userService.getUsers());
        return userDTO2;
    }

    @PostMapping
    public void updateUser(UserDTO userDto) {
        userService.save(userDto);
    }
}
