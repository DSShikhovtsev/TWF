package ru.twf.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.twf.domain.BodyCharacteristic;
import ru.twf.repository.BodyCharacteristicRepository;
import ru.twf.services.BodyCharacteristicService;

import java.util.List;

@Service
public class BodyCharacteristicServiceImpl implements BodyCharacteristicService {

    private final BodyCharacteristicRepository repository;

    public BodyCharacteristicServiceImpl(BodyCharacteristicRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public BodyCharacteristic getBodyCharacteristicById(Long id) {
        return repository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BodyCharacteristic> getBodyCharacteristics() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public BodyCharacteristic save(BodyCharacteristic bodyCharacteristic) {
        return repository.save(bodyCharacteristic);
    }

    @Transactional
    @Override
    public void delete(BodyCharacteristic bodyCharacteristic) {
        repository.delete(bodyCharacteristic);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
