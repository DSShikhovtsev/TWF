package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.Community;
import ru.twf.domain.Season;
import ru.twf.repository.CommunityRepository;
import ru.twf.services.CommunityService;
import ru.twf.services.SeasonService;
import ru.twf.services.UserService;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository repository;
    private final UserService userService;
    private final SeasonService seasonService;

    public CommunityServiceImpl(CommunityRepository repository, UserService userService, SeasonService seasonService) {
        this.repository = repository;
        this.userService = userService;
        this.seasonService = seasonService;
    }

    @Transactional(readOnly = true)
    @Override
    public Community getCommunityById(Long id) {
        return repository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Community> getCommunities() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Community save(Community community) {
        return repository.save(community);
    }

    @Transactional
    @Override
    public void delete(Community community) {
        repository.delete(community);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void getRequestForInviteFromUser(Community community, Long idUser) {
        if (community.getUsers().size() < community.getMemberQuentity().getSize()) {
            //todo approve request from community admins
            community.getUsers().add(userService.getUserById(idUser));
            save(community);
        }
    }

    @Override
    public void addCommunitySeason(Community community, Season season) {
        //todo one global community
        Season isAvailable = seasonService.isExists(season);
        if (isAvailable == null) {
            season.getCommunities().add(community);
            seasonService.save(season);
        } else {
            isAvailable.getCommunities().add(community);
            seasonService.save(isAvailable);
        }
    }
}
