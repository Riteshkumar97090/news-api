package com.codingage.newsapiinjava.service.impl;
import com.codingage.newsapiinjava.Repository.UserRepository;
import com.codingage.newsapiinjava.dto.AuthRequest;
import com.codingage.newsapiinjava.dto.AuthResponse;
import com.codingage.newsapiinjava.model.User;
import com.codingage.newsapiinjava.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

        @Autowired
        private UserRepository userRepository;


        public AuthResponse signup(AuthRequest request) {
            if (userRepository.findByEmail(request.getEmail()) != null) {
                throw new RuntimeException("Email already registered");
            }

            User user = new User();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());

            userRepository.save(user);
            return new AuthResponse("Signup successful");
        }


        public AuthResponse login(AuthRequest request) {
            User user = userRepository.findByEmail(request.getEmail());

            if (user == null) {
                throw new RuntimeException("Email not found");
            }

            if (!user.getPassword().equals(request.getPassword())) {
                throw new RuntimeException("Incorrect password");
            }

            return new AuthResponse("Login successful");

        }
}
