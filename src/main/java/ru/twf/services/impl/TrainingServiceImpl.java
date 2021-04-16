package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.Training;
import ru.twf.repository.TrainingsRepository;
import ru.twf.services.TrainingService;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingsRepository repository;

    public TrainingServiceImpl(TrainingsRepository repository) {
        this.repository = repository;
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
}
