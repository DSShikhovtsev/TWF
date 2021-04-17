package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
}
