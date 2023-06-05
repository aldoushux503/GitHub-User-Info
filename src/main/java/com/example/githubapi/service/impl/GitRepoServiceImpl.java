package com.example.githubapi.service.impl;


import com.example.githubapi.entity.Branch;
import com.example.githubapi.entity.GitHubRepository;
import com.example.githubapi.service.GitRepoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GitRepoServiceImpl implements GitRepoService {
    @Override
    public List<GitHubRepository> getRepositories(String username) {
        String apiUrl = "https://api.github.com/users/" + username + "/repos";

        RestTemplate restTemplate = new RestTemplate();
        GitHubRepository[] repositories;
        try {
            repositories = restTemplate.getForObject(apiUrl, GitHubRepository[].class);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
        }


        List<GitHubRepository> filteredRepositories = new ArrayList<>();

        if (repositories != null) {
            for (GitHubRepository repository : repositories) {
                if (!repository.isFork()) {
                    GitHubRepository detailedRepository = getRepositoryDetails(repository);
                    filteredRepositories.add(detailedRepository);
                }
            }
        }

        return filteredRepositories;
    }

    private GitHubRepository getRepositoryDetails(GitHubRepository repository) {
        String apiUrl = "https://api.github.com/repos/" + repository.getFull_name() + "/branches";

        RestTemplate restTemplate = new RestTemplate();
        Branch[] branches = restTemplate.getForObject(apiUrl, Branch[].class);
        repository.setBranches(Arrays.asList(branches));

        return repository;
    }
}
