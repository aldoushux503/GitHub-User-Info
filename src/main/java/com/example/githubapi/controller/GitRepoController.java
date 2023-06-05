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
        if ("application/json".equalsIgnoreCase(acceptHeader)) {
            // Call the GitHub service to retrieve repositories in JSON format
            return ResponseEntity.ok(repoService.getRepositories(username));
        } else if ("application/xml".equalsIgnoreCase(acceptHeader)) {
            // Return 406 response for unsupported media type
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            // Return 400 response for unsupported media type
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}