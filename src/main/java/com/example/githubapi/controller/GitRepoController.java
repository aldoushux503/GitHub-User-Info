package com.example.githubapi.controller;

import com.example.githubapi.service.GitRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repositories")
public class GitRepoController {

    private final GitRepoService repoService;

    @Autowired
    public GitRepoController(GitRepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping(value = "/{username}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getUserRepositories(@PathVariable String username) {
        return ResponseEntity.ok(repoService.getRepositories(username));
    }

}