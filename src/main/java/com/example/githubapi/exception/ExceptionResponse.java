package com.example.githubapi.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ExceptionResponse {
    private int status;
    private String message;
}