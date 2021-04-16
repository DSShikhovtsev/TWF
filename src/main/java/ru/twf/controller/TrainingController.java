package ru.twf.controller;

import org.springframework.web.bind.annotation.*;
import ru.twf.domain.Training;
import ru.twf.services.TrainingService;

import java.util.List;

@RestController
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/trainings/{id}")
    public Training getTraining(@PathVariable(name = "id") Long id) {
        return trainingService.getTrainingById(id);
    }

    @GetMapping("/trainings")
    public List<Training> getTrainings() {
        return trainingService.getTrainings();
    }

    @PostMapping("/trainings")
    public Training save(@RequestBody Training training) {
        return trainingService.save(training);
    }

    @DeleteMapping("/trainings")
    public void delete(@RequestBody Training training) {
        trainingService.delete(training);
    }

    @DeleteMapping("/trainings/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        trainingService.deleteById(id);
    }
}
