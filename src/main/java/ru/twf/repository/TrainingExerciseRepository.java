package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.TrainingExercise;

public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Long> {
}
