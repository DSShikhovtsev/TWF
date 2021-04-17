package ru.twf.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {

    void deleteById(Long id);

    Resource loadAsResource();

    byte[] loadAsBytes();

    void store(MultipartFile file);
}
