package com.example.githubapi.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
            throws HttpMediaTypeNotAcceptableException {
        String accept=request.getHeader(HttpHeaders.ACCEPT);

        if(!MediaType.APPLICATION_JSON_VALUE.equals(accept)) {
            throw new HttpMediaTypeNotAcceptableException("Not acceptable media type");
        }

        return true;
    }

}
