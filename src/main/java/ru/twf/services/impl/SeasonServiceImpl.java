package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.Season;
import ru.twf.repository.SeasonRepository;
import ru.twf.services.SeasonService;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository repository;

    public SeasonServiceImpl(SeasonRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public Season getSeasonById(Long id) {
        return repository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Season> getSeasons() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Season save(Season season) {
        return repository.save(season);
    }

    @Transactional
    @Override
    public void delete(Season season) {
        repository.delete(season);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
