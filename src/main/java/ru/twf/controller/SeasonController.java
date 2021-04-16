package ru.twf.controller;

import org.springframework.web.bind.annotation.*;
import ru.twf.domain.Season;
import ru.twf.services.SeasonService;

import java.util.List;

@RestController
public class SeasonController {

    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping("/seasons/{id}")
    public Season getSeason(@PathVariable(name = "id") Long id) {
        return seasonService.getSeasonById(id);
    }

    @GetMapping("/seasons")
    public List<Season> getSeasons() {
        return seasonService.getSeasons();
    }

    @PostMapping("/seasons")
    public Season save(@RequestBody Season season) {
        return seasonService.save(season);
    }

    @DeleteMapping("/seasons")
    public void delete(@RequestBody Season season) {
        seasonService.delete(season);
    }

    @DeleteMapping("/seasons/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        seasonService.deleteById(id);
    }
}
