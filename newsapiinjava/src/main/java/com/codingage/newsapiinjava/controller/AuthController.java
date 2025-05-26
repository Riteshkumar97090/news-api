package com.codingage.newsapiinjava.controller;

import com.codingage.newsapiinjava.dto.AuthRequest;
import com.codingage.newsapiinjava.dto.AuthResponse;
import com.codingage.newsapiinjava.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/api/auth")
    @CrossOrigin(origins = "http://localhost:5173") //
    public class AuthController {


        @Autowired
        private AuthService authService;

        @PostMapping("/signup")
        public AuthResponse signup(@RequestBody AuthRequest request) {
            return authService.signup(request);
        }

        @PostMapping("/login")
        public AuthResponse login(@RequestBody AuthRequest request) {
            return authService.login(request);

    }
}
