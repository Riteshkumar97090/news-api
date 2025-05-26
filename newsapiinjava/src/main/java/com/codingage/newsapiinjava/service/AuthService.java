package com.codingage.newsapiinjava.service;

import com.codingage.newsapiinjava.dto.AuthRequest;
import com.codingage.newsapiinjava.dto.AuthResponse;

public interface AuthService {

        AuthResponse signup(AuthRequest request);
        AuthResponse login(AuthRequest request);

}

