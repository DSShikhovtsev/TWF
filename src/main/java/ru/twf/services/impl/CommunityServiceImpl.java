package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.Community;
import ru.twf.repository.CommunityRepository;
import ru.twf.services.CommunityService;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository repository;

    public CommunityServiceImpl(CommunityRepository repository) {
        this.repository = repository;
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
}
