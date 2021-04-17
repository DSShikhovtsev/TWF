package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.Training;
import ru.twf.domain.User;

import java.util.List;

public interface TrainingsRepository extends JpaRepository<Training, Long> {

    List<Training> findAllByUser(User user);
}
