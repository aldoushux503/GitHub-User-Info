package com.example.githubapi.service;


import com.example.githubapi.entity.GitHubRepository;
import java.util.List;

public interface GitRepoService {
    List<GitHubRepository> getRepositories(String username);
}
