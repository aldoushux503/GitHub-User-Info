package com.example.githubapi.service.impl;


import com.example.githubapi.entity.GitHubRepository;
import com.example.githubapi.service.GitRepoService;
import org.springframework.stereotype.Service;
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
        GitHubRepository[] repositories = restTemplate.getForObject(apiUrl, GitHubRepository[].class);

        List<GitHubRepository> filteredRepositories = new ArrayList<>();

        if (repositories != null) {
            for (GitHubRepository repository : repositories) {
                if (!repository.isFork()) {

                }
            }
        }

        return filteredRepositories;
    }


}
