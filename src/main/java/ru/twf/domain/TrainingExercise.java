package ru.twf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

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
}
