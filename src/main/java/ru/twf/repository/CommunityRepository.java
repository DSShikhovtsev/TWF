package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.twf.domain.Community;
import ru.twf.domain.User;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community, Long> {

    @Query(value = "select c from Community c where ?1 in (c.users)")
    List<Community> findAllByUser(User user);
}
