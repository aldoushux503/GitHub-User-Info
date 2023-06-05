package com.example.githubapi.controller;


import com.example.githubapi.service.GitRepoService;
import com.example.githubapi.service.impl.GitRepoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repositories")
public class GitRepoController {

    private final GitRepoService repoService;

    public GitRepoController(GitRepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserRepositories(
            @PathVariable String username,
            @RequestHeader("Accept") String acceptHeader
    ) {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}