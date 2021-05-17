package ru.twf.services;

import ru.twf.domain.Community;
import ru.twf.domain.Leaderboard;
import ru.twf.domain.Season;
import ru.twf.domain.User;

import java.util.List;

public interface LeaderboardService {

    Leaderboard getLeaderboardById(Long id);
    List<Leaderboard> getLeaderboards();
    Leaderboard save(Leaderboard leaderboard);
    void delete(Leaderboard leaderboard);
    void deleteById(Long id);

    Leaderboard getBySeasonAndCommunity(Season season, Community community);
    List<Leaderboard> getAllByUser(User user);
    List<Leaderboard> getAllByUserAndSeasonAndCommunity(User user, Season season, Community community);
    Leaderboard updatePositions(Leaderboard leaderboard);
}
