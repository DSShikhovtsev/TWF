package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.User;
import ru.twf.dto.UserDTO;
import ru.twf.repository.UserRepository;
import ru.twf.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDTO getUserDTOById(Long id) {
        return convertToUserDTO(repository.getOne(id));
    }

    @Override
    public User getUserById(Long id) {
        return repository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDTO> getUserDTOs() {
        return repository.findAll().stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO saveUserDTO(UserDTO userDTO) {
        return convertToUserDTO(repository.save(convertToUser(userDTO)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAbout(user.getAbout());
        userDTO.setCity(user.getCity());
        userDTO.setRegion(user.getRegion());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setSex(user.getSex());
        userDTO.setWeight(user.getWeight());
        return userDTO;
    }

    private User convertToUser(UserDTO userDTO) {
        User user = repository.getOne(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAbout(userDTO.getAbout());
        user.setCity(userDTO.getCity());
        user.setRegion(userDTO.getRegion());
        user.setBirthday(userDTO.getBirthday());
        user.setSex(userDTO.getSex());
        user.setWeight(userDTO.getWeight());
        return user;
    }
}
