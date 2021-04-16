package ru.twf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.twf.domain.User;
import ru.twf.services.UserService;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @GetMapping("users")
    public User getOwn() {
        return userService.getUserById(1L);
    }

    @PostMapping
    public void updateUser(User user) {
        logger.info(user.getName());
    }
}
