package ru.twf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class BodyCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private long weight;

    @Column
    private double height;

    @Column
    private LocalDateTime date;

    @Column
    private Boolean isDesired;

    /*@ManyToOne(targetEntity = User.class)
    @JoinTable(name = "users_characteristics", @JoinColumn(name = "characteristic_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;*/

}
