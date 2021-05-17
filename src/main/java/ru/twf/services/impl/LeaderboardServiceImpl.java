package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.Community;
import ru.twf.domain.Leaderboard;
import ru.twf.domain.Season;
import ru.twf.domain.User;
import ru.twf.repository.LeaderboardRepository;
import ru.twf.services.CommunityService;
import ru.twf.services.LeaderboardService;

import java.util.List;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    private final LeaderboardRepository repository;
    private final CommunityService communityService;

    public LeaderboardServiceImpl(LeaderboardRepository repository, CommunityService communityService) {
        this.repository = repository;
        this.communityService = communityService;
    }

    @Transactional(readOnly = true)
    @Override
    public Leaderboard getLeaderboardById(Long id) {
        return repository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Leaderboard> getLeaderboards() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Leaderboard save(Leaderboard leaderboard) {
        return repository.save(leaderboard);
    }

    private void saveAll(List<Leaderboard> leaderboards) {
        for (Leaderboard leaderboard : leaderboards)
            save(leaderboard);
    }

    @Transactional
    @Override
    public void delete(Leaderboard leaderboard) {
        repository.delete(leaderboard);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Leaderboard getBySeasonAndCommunity(Season season, Community community) {
        return repository.findBySeasonAndCommunity(season, community);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Leaderboard> getAllByUser(User user) {
        return repository.findAllByUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Leaderboard> getAllByUserAndSeasonAndCommunity(User user, Season season, Community community) {
        return repository.findAllByUserAndSeasonAndCommunity(user, season, community);
    }

    //пользователь потренировался -> обновляем все лидерборды по сообществам пользователя и текущим сезонам
    @Transactional
    @Override
    public Leaderboard updatePositions(Leaderboard leaderboard) {
        List<Community> communities = communityService.getAllByUser(leaderboard.getUser());
        for (Community com : communities) {
            List<Leaderboard> leaderboards = getAllByUserAndSeasonAndCommunity(leaderboard.getUser(), leaderboard.getSeason(), com);
            leaderboards.sort((t, y) -> (int) (t.getPoints() - y.getPoints()));
            for (int i = 1; i < leaderboards.size() + 1; i++) leaderboards.get(i).setPosition((long) i);//some shit
            saveAll(leaderboards);
        }
        return leaderboard;
    }

}
