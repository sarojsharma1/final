package com.example.backfinal.controller;

import com.example.backfinal.dto.LoginRequest;
import com.example.backfinal.dto.LoginResponse;
import com.example.backfinal.entity.User;
import com.example.backfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse userLogin(@RequestBody LoginRequest loginRequest) throws Exception {
        return userService.login(loginRequest);
    }
}
