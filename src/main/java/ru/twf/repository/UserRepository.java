package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
