package ru.twf.services;

import ru.twf.domain.Community;
import ru.twf.domain.Season;
import ru.twf.domain.User;

import java.util.List;

public interface CommunityService {

    //default crud
    Community getCommunityById(Long id);
    List<Community> getCommunities();
    Community save(Community community);
    void delete(Community community);
    void deleteById(Long id);

    //other
    void getRequestForInviteFromUser(Community community, Long idUser);
    void addCommunitySeason(Community community, Season season);
    List<Community> getAllByUser(User user);
}
