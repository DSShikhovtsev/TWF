package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.Training;

public interface TrainingsRepositor extends JpaRepository<Training, Long> {
}
