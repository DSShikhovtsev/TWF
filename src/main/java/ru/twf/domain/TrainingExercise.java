package ru.twf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class TrainingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String exercise;

    @Column
    private long doingTime;

    @Column
    private long relaxTime;

    /* вроде не нужно
    @ManyToMany(targetEntity = Training.class)
    @JoinTable(name = "training_trainingExcersises", joinColumns = @JoinColumn(name = "training_excersises_id"),
        inverseJoinColumns = @JoinColumn(name = "training_id"))
    private List<Training> trainings;*/
}
