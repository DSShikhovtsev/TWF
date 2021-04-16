package ru.twf.services;

import ru.twf.domain.Community;

import java.util.List;

public interface CommunityService {

    Community getCommunityById(Long id);
    List<Community> getCommunities();
    Community save(Community community);
    void delete(Community community);
    void deleteById(Long id);
}
