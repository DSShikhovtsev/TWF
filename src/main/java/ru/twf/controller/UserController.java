package ru.twf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.twf.dto.UserDTO;
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
        return userService.getUserDTOs();
    }

    @GetMapping("users/{id}")
    public UserDTO getOwn(@PathVariable("id") Long id) {
        return userService.getUserDTOById(id);
    }

    @PostMapping("users")
    public void updateUser(@RequestBody UserDTO userDto) {
        userService.saveUserDTO(userDto);
    }
}
