package com.example.githubapi.service;


import java.util.List;

public interface GitRepoService {
    List<?> getRepositories(String username);
}
