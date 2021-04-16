package ru.twf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.twf.domain.BodyCharacteristic;

public interface BodyCharacteristicRepository extends JpaRepository<BodyCharacteristic, Long> {
}
