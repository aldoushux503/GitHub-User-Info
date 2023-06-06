package com.example.githubapi.service.impl;


import com.example.githubapi.entity.Branch;
import com.example.githubapi.entity.GitHubRepository;
import com.example.githubapi.service.GitRepoService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GitRepoServiceImpl implements GitRepoService {

    private final WebClient webClient;

    @Autowired
    public GitRepoServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<GitHubRepository> getRepositories(String username) {
        return webClient.get()
                .uri("users/{username}/repos", username)
                .retrieve()
                .bodyToFlux(GitHubRepository.class)
                .filter(e -> !e.isFork())
                .flatMap(this::getRepositoryDetails)
                .collectList()
                .block();
    }

    private Mono<GitHubRepository> getRepositoryDetails(GitHubRepository repository) {
        return webClient.get()
                .uri("repos/{fullName}/branches", repository.getFull_name())
                .retrieve()
                .bodyToFlux(Branch.class)
                .collectList()
                .flatMap(branches -> {
                    repository.setBranches(branches);
                    return Mono.just(repository);
                });
    }

}
