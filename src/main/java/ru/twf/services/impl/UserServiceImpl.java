package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import ru.twf.domain.User;
import ru.twf.repository.UserRepository;
import ru.twf.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
