package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.Training;
import ru.twf.domain.TrainingExercise;
import ru.twf.domain.User;
import ru.twf.dto.UserDTO;
import ru.twf.enums.TrainingType;
import ru.twf.repository.TrainingsRepository;
import ru.twf.services.TrainingService;
import ru.twf.services.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingsRepository repository;
    private final UserService userService;

    public TrainingServiceImpl(TrainingsRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Transactional(readOnly = true)
    @Override
    public Training getTrainingById(Long id) {
        return repository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Training> getTrainings() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Training save(Training training) {
        return repository.save(training);
    }

    @Transactional
    @Override
    public void delete(Training training) {
        repository.delete(training);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Training> getUserTrainings(UserDTO userDTO) {
        return repository.findAllByUser(userService.convertToUser(userDTO));
    }

    @Transactional
    @Override
    public Training startTraining(User user, TrainingType type) {
        Training training = new Training();
        training.setStartDate(LocalDateTime.now());
        training.setCalories(0L);
        training.setType(type);
        training.setUser(user);
        return save(training);
    }

    @Transactional
    @Override
    public Training finishTrain(Training training, List<TrainingExercise> exercises) {
        training.setEndDate(LocalDateTime.now());
        training.getTrainingExercises().addAll(exercises);
        return save(training);
    }
}
