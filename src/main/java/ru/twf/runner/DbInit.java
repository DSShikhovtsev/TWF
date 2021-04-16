package ru.twf.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import ru.twf.domain.User;
import ru.twf.repository.UserRepository;

public class DbInit implements ApplicationRunner {

    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(createUser("Murat"));
        userRepository.save(createUser("Ilya"));
        userRepository.save(createUser("Dima"));
        userRepository.save(createUser("Dawn"));
        userRepository.save(createUser("Stas"));
        userRepository.save(createUser("Kek"));
    }

    private User createUser(String userName) {
        User user = new User();
        user.setName(userName);
        return user;
    }
}
