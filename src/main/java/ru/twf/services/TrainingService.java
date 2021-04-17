package ru.twf.services;

import ru.twf.domain.Training;
import ru.twf.dto.UserDTO;

import java.util.List;

public interface TrainingService {

    Training getTrainingById(Long id);
    List<Training> getTrainings();
    Training save(Training training);
    void delete(Training training);
    void deleteById(Long id);

    List<Training> getUserTrainings(UserDTO userDTO);
}
