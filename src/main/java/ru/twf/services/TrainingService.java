package ru.twf.services;

import ru.twf.domain.Training;
import ru.twf.domain.TrainingExercise;
import ru.twf.domain.User;
import ru.twf.dto.UserDTO;
import ru.twf.enums.TrainingType;

import java.util.List;

public interface TrainingService {

    Training getTrainingById(Long id);
    List<Training> getTrainings();
    Training save(Training training);
    void delete(Training training);
    void deleteById(Long id);

    List<Training> getUserTrainings(UserDTO userDTO);
    Training startTraining(User user, TrainingType type);
    Training finishTrain(Training train, List<TrainingExercise> exercise);
}
