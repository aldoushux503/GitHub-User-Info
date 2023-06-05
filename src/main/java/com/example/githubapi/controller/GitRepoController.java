package com.example.githubapi.controller;


import com.example.githubapi.error.ErrorResponse;
import com.example.githubapi.service.GitRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.Map;

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
    ) {
        if ("application/json".equalsIgnoreCase(acceptHeader)) {
            try {
                // Call the GitHub service to retrieve repositories in JSON format
                return ResponseEntity.ok(repoService.getRepositories(username));
            }
            catch (HttpClientErrorException e) {
                // Return 404 response for non-existent GitHub user
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(createErrorResponse(404, "Non-existent Github user"));
            }
        }  else if ("application/xml".equalsIgnoreCase(acceptHeader)) {
            // Return 406 response for unsupported media type
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(createErrorResponse(406, "Not acceptable media type"));
        } else {
            // Return 400 response for unsupported media type
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createErrorResponse(400, "Invalid Accept header"));
        }
    }


    private ErrorResponse createErrorResponse(int status, String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(status);
        errorResponse.setMessage(message);
        return errorResponse;
    }

}