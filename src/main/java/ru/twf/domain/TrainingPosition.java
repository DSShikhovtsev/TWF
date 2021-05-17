package ru.twf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

//нахера эта таблица?
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class TrainingPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
