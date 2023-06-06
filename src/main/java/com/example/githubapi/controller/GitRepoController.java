package com.example.githubapi.controller;

import com.example.githubapi.service.GitRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repositories")
public class GitRepoController {

    private final GitRepoService repoService;

    @Autowired
    public GitRepoController(GitRepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserRepositories(
            @PathVariable String username,
            @RequestHeader("Accept") String acceptHeader
    ) throws HttpMediaTypeNotSupportedException, HttpMediaTypeNotAcceptableException {
        if ("application/json".equalsIgnoreCase(acceptHeader)) {
            // Call the GitHub service to retrieve repositories in JSON format
            return ResponseEntity.ok(repoService.getRepositories(username));
        } else if ("application/xml".equalsIgnoreCase(acceptHeader)) {
            throw new HttpMediaTypeNotAcceptableException("Not acceptable media type");
        } else {
            throw new HttpMediaTypeNotSupportedException("Invalid Accept header");
        }
    }

}