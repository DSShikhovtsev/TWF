package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.Season;

import java.time.LocalDateTime;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    Season findByNameAndStartDateAndEndDate(String name, LocalDateTime startDate, LocalDateTime endDate);
}
