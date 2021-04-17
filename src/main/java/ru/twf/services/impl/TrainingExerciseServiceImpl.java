package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import ru.twf.domain.TrainingExercise;
import ru.twf.repository.TrainingExerciseRepository;
import ru.twf.services.TrainingExerciseService;

import java.util.List;

@Service
public class TrainingExerciseServiceImpl implements TrainingExerciseService {

    private final TrainingExerciseRepository repository;

    public TrainingExerciseServiceImpl(TrainingExerciseRepository repository) {
        this.repository = repository;
    }

    @Override
    public TrainingExercise getTrainingExerciseById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<TrainingExercise> getTrainingExercises() {
        return repository.findAll();
    }

    @Override
    public TrainingExercise save(TrainingExercise trainingExercise) {
        return repository.save(trainingExercise);
    }

    @Override
    public void delete(TrainingExercise trainingExercise) {
        repository.delete(trainingExercise);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
