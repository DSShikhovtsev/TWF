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
        userRepository.save(User.builder().login("Murat").password("1").firstName("Мурат").lastName("Zhul").about("dota 2 busting").weight(116).build());
        userRepository.save(User.builder().login("Ilya").password("1").firstName("Ilya").lastName("Shikh").birthday(LocalDate.of(1997, 5, 15)).build());
        userRepository.save(User.builder().login("Dima").password("1").firstName("Dima").lastName("Shikh").weight(78).build());
        userRepository.save(User.builder().login("Dawn").password("1").firstName("Dawn").lastName("Breaker").sex(Sex.FEMALE).build());
        userRepository.save(User.builder().login("Stas").password("1").firstName("Stas").lastName("Mikhailov").city("HUITI").build());
        userRepository.save(User.builder().login("Shrek").password("1").firstName("Kek").region("HUEDGN").build());
    }
}
