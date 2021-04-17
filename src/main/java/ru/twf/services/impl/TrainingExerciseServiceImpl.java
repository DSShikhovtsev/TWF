package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.Training;
import ru.twf.domain.TrainingExercise;
import ru.twf.domain.User;
import ru.twf.dto.UserDTO;
import ru.twf.repository.TrainingExerciseRepository;
import ru.twf.services.TrainingExerciseService;
import ru.twf.services.TrainingService;
import ru.twf.services.UserService;

import java.util.List;

@Service
@Transactional
public class TrainingExerciseServiceImpl implements TrainingExerciseService {

    private final TrainingExerciseRepository repository;

    public TrainingExerciseServiceImpl(TrainingExerciseRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public TrainingExercise getTrainingExerciseById(Long id) {
        return repository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TrainingExercise> getTrainingExercises() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public TrainingExercise save(TrainingExercise trainingExercise) {
        return repository.save(trainingExercise);
    }

    @Transactional
    @Override
    public void delete(TrainingExercise trainingExercise) {
        repository.delete(trainingExercise);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TrainingExercise> getTrainingUserTrainingExercise(Training training) {
        return training.getTrainingExercises();
    }
}
