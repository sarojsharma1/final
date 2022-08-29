package com.example.backend.controller;
import com.example.backend.dto.login.AuthRequest;
import com.example.backend.dto.login.AuthResponse;
import com.example.backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public AuthResponse userLogin(@RequestBody AuthRequest authRequest) throws Exception
    {
        return loginService.login(authRequest);
    }
}
