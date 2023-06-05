package com.example.githubapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GitHubRepository {

    private String name;

    private Owner owner;

    private List<Branch> branches;

    private boolean fork;

    private String full_name;
}

