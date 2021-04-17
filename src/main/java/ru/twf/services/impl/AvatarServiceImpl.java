package ru.twf.services.impl;

import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.twf.domain.Avatar;
import ru.twf.domain.User;
import ru.twf.repository.AvatarRepository;
import ru.twf.services.AvatarService;
import ru.twf.services.StorageService;

import java.nio.file.Path;

@Service
public class AvatarServiceImpl implements AvatarService {

    private final AvatarRepository avatarRepository;
    private final StorageService storageService;

    public AvatarServiceImpl(AvatarRepository avatarRepository, StorageService storageService) {
        this.avatarRepository = avatarRepository;
        this.storageService = storageService;
    }

    @Override
    public Resource loadAsResource() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Avatar avatar = avatarRepository.getOne(currentUser.getId());

        return storageService.loadAsResource(avatar.getAvatarPath());
    }

    @Override
    public byte[] loadAsBytes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Avatar avatar = avatarRepository.getOne(currentUser.getId());

        return storageService.load(avatar.getAvatarPath());
    }

    @Override
    public void store(MultipartFile file) {
        Path store = storageService.store(file);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Avatar avatar = avatarRepository.getOne(currentUser.getId());
        avatar.setAvatarPath(store.toString());

        avatarRepository.save(avatar);
    }

    @Override
    public void deleteById(Long id) {
        avatarRepository.deleteById(id);
    }
}
