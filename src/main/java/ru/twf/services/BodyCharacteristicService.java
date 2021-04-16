package ru.twf.services;

import ru.twf.domain.BodyCharacteristic;

import java.util.List;

public interface BodyCharacteristicService {

    BodyCharacteristic getBodyCharacteristicById(Long id);
    List<BodyCharacteristic> getBodyCharacteristics();
    BodyCharacteristic save(BodyCharacteristic bodyCharacteristic);
    void delete(BodyCharacteristic bodyCharacteristic);
    void deleteById(Long id);
}
