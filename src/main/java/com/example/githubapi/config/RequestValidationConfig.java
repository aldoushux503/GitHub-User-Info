package com.example.githubapi.config;

import com.example.githubapi.interceptor.RequestValidationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestValidationConfig implements WebMvcConfigurer {

    private final RequestValidationInterceptor requestInterceptor;

    @Autowired
    public RequestValidationConfig(RequestValidationInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry register) {
        register.addInterceptor(requestInterceptor);
    }

}
