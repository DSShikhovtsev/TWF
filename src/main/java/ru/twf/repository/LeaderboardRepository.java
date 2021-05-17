package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.Community;
import ru.twf.domain.Leaderboard;
import ru.twf.domain.Season;
import ru.twf.domain.User;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

    Leaderboard findBySeasonAndCommunity(Season season, Community community);

    List<Leaderboard> findAllByUser(User user);
    List<Leaderboard> findAllByUserAndSeasonAndCommunity(User user, Season season, Community community);
}
