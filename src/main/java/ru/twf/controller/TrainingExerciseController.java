package ru.twf.controller;

import org.springframework.web.bind.annotation.*;
import ru.twf.domain.Training;
import ru.twf.domain.TrainingExercise;
import ru.twf.dto.UserDTO;
import ru.twf.services.TrainingExerciseService;

import java.util.List;

@RestController
public class TrainingExerciseController {

    private final TrainingExerciseService trainingExerciseService;

    public TrainingExerciseController(TrainingExerciseService trainingExerciseService) {
        this.trainingExerciseService = trainingExerciseService;
    }

    @GetMapping("/exercises/{id}")
    public TrainingExercise getTrainingExercise(@PathVariable(name = "id") Long id) {
        return trainingExerciseService.getTrainingExerciseById(id);
    }

    @GetMapping("/exercises")
    public List<TrainingExercise> getTrainingExercises() {
        return trainingExerciseService.getTrainingExercises();
    }

    @GetMapping("/users/trainings/exercises")
    public List<TrainingExercise> getUserTrainingExercises(@RequestBody Training training) {
        return trainingExerciseService.getTrainingUserTrainingExercise(training);
    }

    @PostMapping("/exercises")
    public TrainingExercise save(@RequestBody TrainingExercise trainingExercise) {
        return trainingExerciseService.save(trainingExercise);
    }

    @DeleteMapping("/exercises")
    public void delete(@RequestBody TrainingExercise trainingExercise) {
        trainingExerciseService.delete(trainingExercise);
    }

    @DeleteMapping("/exercises/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        trainingExerciseService.deleteById(id);
    }
}
