package ru.twf.controller;

import org.springframework.web.bind.annotation.*;
import ru.twf.domain.Community;
import ru.twf.services.CommunityService;

import java.util.List;

@RestController
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/communities")
    public List<Community> getCommunities() {
        return communityService.getCommunities();
    }

    @GetMapping("/communities/{id}")
    public Community getCommunity(@PathVariable(name = "id") Long id) {
        return communityService.getCommunityById(id);
    }

    @PostMapping("/communities")
    public Community saveCommunity(@RequestBody Community community) {
        return communityService.save(community);
    }

    @DeleteMapping("/communities")
    public void deleteCommunity(@RequestBody Community community) {
        communityService.delete(community);
    }

    @DeleteMapping("/communities/{id}")
    public void deleteCommunityById(@PathVariable(name = "id") Long id) {
        communityService.deleteById(id);
    }
}
