package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
