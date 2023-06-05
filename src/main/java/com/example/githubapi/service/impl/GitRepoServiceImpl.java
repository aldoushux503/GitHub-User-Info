package com.example.githubapi.service.impl;


import com.example.githubapi.service.GitRepoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitRepoServiceImpl implements GitRepoService {
    @Override
    public List<?> getRepositories(String username) {
        return null;
    }
}
