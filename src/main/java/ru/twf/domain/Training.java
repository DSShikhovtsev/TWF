package ru.twf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.twf.enums.TrainingType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private long calories;

    @Column(nullable = false)
    private TrainingType type;

    @ManyToOne(targetEntity = User.class)
    @JoinTable(name = "users_trainings", joinColumns = @JoinColumn(name = "training_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;

    @ManyToMany(targetEntity = TrainingExercise.class)
    @JoinTable(name = "trainings_trainingsExcercises", joinColumns = @JoinColumn(name = "training_id"),
        inverseJoinColumns = @JoinColumn(name = "training_excercise_id"))
    private List<TrainingExercise> trainingExercises;
}
