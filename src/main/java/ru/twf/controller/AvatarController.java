package ru.twf.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.twf.services.AvatarService;

//@Controller
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping("avatar")
    public Resource getAvatar() {
        return avatarService.loadAsResource();
    }

    @GetMapping(value = "avatarBytes", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getAvatarBytes() {
        return avatarService.loadAsBytes();
    }

    @GetMapping("avatarR")
    public ResponseEntity<Resource> getAvatarR() {
        Resource file = avatarService.loadAsResource();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("avatarBytesR")
    public ResponseEntity<Resource> getAvatarBytesR() {
        Resource file = avatarService.loadAsResource();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        avatarService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleStorageFileNotFound(RuntimeException exc) {
        return ResponseEntity.notFound().build();
    }
}
