package ru.twf.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    Path store(MultipartFile file);

    Stream<Path> loadAll();

    byte[] load(String filename);

    Resource loadAsResource(String filename);

    void delete(String filename);

}
