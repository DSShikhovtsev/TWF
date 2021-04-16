package ru.twf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.twf.domain.User;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("users")
    public User getOwn() {
        //todo get own User by spring sec
        User user = new User();
        user.setName("Murat");
        return user;
    }

    @PostMapping
    public void updateUser(User user) {
        logger.info(user.getName());
    }
}
