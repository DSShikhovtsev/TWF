package ru.twf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Avatar {
    @Id
    private Long id;

    @Column(nullable = false)
    private String avatarPath;
}
