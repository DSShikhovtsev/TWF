package ru.twf.controller;

import org.springframework.web.bind.annotation.*;
import ru.twf.domain.BodyCharacteristic;
import ru.twf.services.BodyCharacteristicService;

import java.util.List;

@RestController
public class BodyCharacteristicController {

    private final BodyCharacteristicService bodyCharacteristicService;

    public BodyCharacteristicController(BodyCharacteristicService bodyCharacteristicService) {
        this.bodyCharacteristicService = bodyCharacteristicService;
    }

    @GetMapping("/users/bodyCharacteristics/{id}")
    public BodyCharacteristic getBodyCharacteristic(@PathVariable(name = "id") Long id) {
        return bodyCharacteristicService.getBodyCharacteristicById(id);
    }

    @GetMapping("/users/bodyCharacteristics")
    public List<BodyCharacteristic> getBodyCharacteristics() {
        return bodyCharacteristicService.getBodyCharacteristics();
    }

    @PostMapping("/users/bodyCharacteristic")
    public BodyCharacteristic save(@RequestBody BodyCharacteristic bodyCharacteristic) {
        return bodyCharacteristicService.save(bodyCharacteristic);
    }

    @DeleteMapping("/users/bodyCharacteristic")
    public void delete(@RequestBody BodyCharacteristic bodyCharacteristic) {
        bodyCharacteristicService.delete(bodyCharacteristic);
    }

    @DeleteMapping("/users/bodyCharacteristic/{id}")
    public void deleteBodyCharacteristicById(@PathVariable(name = "id") Long id) {
        bodyCharacteristicService.deleteById(id);
    }
}
