package ru.twf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.twf.domain.Training;
import ru.twf.dto.UserDTO;
import ru.twf.services.TrainingService;
import ru.twf.services.UserService;

import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final TrainingService trainingService;

    public UserController(UserService userService, TrainingService trainingService) {
        this.userService = userService;
        this.trainingService = trainingService;
    }

    @GetMapping("/users")
    public List<UserDTO> getOwn() {
        return userService.getUserDTOs();
    }

    @GetMapping("/users/{id}")
    public UserDTO getOwn(@PathVariable("id") Long id) {
        return userService.getUserDTOById(id);
    }

    @PostMapping("/users")
    public void updateUser(@RequestBody UserDTO userDto) {
        userService.saveUserDTO(userDto);
    }

    @DeleteMapping("/users")
    public void delete(@RequestBody UserDTO userDTO) {
        userService.deleteById(userDTO.getId());
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/users/trainings")
    public List<Training> getUserTrainings(@RequestBody UserDTO userDTO) {
        return trainingService.getUserTrainings(userDTO);
    }
}
