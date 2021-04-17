package ru.twf.services;

import ru.twf.domain.TrainingExercise;

import java.util.List;

public interface TrainingExerciseService {

    TrainingExercise getTrainingExerciseById(Long id);
    List<TrainingExercise> getTrainingExercises();
    TrainingExercise save(TrainingExercise trainingExercise);
    void delete(TrainingExercise trainingExercise);
    void deleteById(Long id);
}
