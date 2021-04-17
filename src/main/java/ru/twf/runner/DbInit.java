package ru.twf.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.twf.domain.User;
import ru.twf.enums.Sex;
import ru.twf.repository.UserRepository;

import java.time.LocalDate;

@Component
public class DbInit implements ApplicationRunner {

    private final UserRepository userRepository;

    public DbInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        fillUsers();
    }

    private void fillUsers() {
        userRepository.save(User.builder().firstName("Мурат").lastName("Zhul").about("dota 2 busting").weight(116).build());
        userRepository.save(User.builder().firstName("Ilya").lastName("Shikh").birthday(LocalDate.of(1997, 5, 15)).build());
        userRepository.save(User.builder().firstName("Dima").lastName("Shikh").weight(78).build());
        userRepository.save(User.builder().firstName("Dawn").lastName("Breaker").sex(Sex.FEMALE).build());
        userRepository.save(User.builder().firstName("Stas").lastName("Mikhailov").city("HUITI").build());
        userRepository.save(User.builder().firstName("Kek").region("HUEDGN").build());
    }
}
