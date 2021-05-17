package ru.twf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long position;

    @Column
    private Long points;

    @ManyToOne(targetEntity = User.class)
    @JoinTable(name = "users_leaderboard", joinColumns = @JoinColumn(name = "id_leaderboard"),
        inverseJoinColumns = @JoinColumn(name = "id_user"))
    private User user;

    @ManyToOne(targetEntity = Community.class)
    @JoinTable(name = "community_leaderboard", joinColumns = @JoinColumn(name = "id_leaderboard"),
        inverseJoinColumns = @JoinColumn(name = "id_community"))
    private Community community;

    @ManyToOne(targetEntity = Season.class)
    @JoinTable(name = "season_leaderboard", joinColumns = @JoinColumn(name = "id_leaderboard"),
        inverseJoinColumns = @JoinColumn(name = "id_season"))
    private Season season;
}
