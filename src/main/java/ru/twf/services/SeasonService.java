package ru.twf.services;

import ru.twf.domain.Season;

import java.util.List;

public interface SeasonService {

    Season getSeasonById(Long id);
    List<Season> getSeasons();
    Season save(Season season);
    void delete(Season season);
    void deleteById(Long id);

    Season isAvailable(Season season);
}
