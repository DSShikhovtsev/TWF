package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.Training;

public interface TrainingsRepository extends JpaRepository<Training, Long> {
}
