package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.Community;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
