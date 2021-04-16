package ru.twf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.twf.enums.MemberQuentity;
import ru.twf.enums.TrainingType;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private TrainingType type;

    @Column
    private MemberQuentity memberQuentity;

    /*@ManyToMany(targetEntity = User.class)
    @JoinTable(name = "users_communities", joinColumns = @JoinColumn(name = "id_community"),
        inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;*/
}
