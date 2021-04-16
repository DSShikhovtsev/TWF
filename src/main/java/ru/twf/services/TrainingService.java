package ru.twf.services;

import ru.twf.domain.Training;

import java.util.List;

public interface TrainingService {

    Training getTrainingById(Long id);
    List<Training> getTrainings();
    Training save(Training training);
    void delete(Training training);
    void deleteById(Long id);
}
