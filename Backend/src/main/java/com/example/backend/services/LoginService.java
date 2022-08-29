package com.example.backend.services;
import com.example.backend.dto.login.AuthRequest;
import com.example.backend.dto.login.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Base64;


@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    public AuthResponse login(AuthRequest authRequest) throws Exception {
        try {
            Authentication authenticate = authenticationManager.authenticate
                                          (new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authenticate);
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)
                                                                        authenticate.getPrincipal();
            String input = authRequest.getUsername() + ":" + authRequest.getPassword();
            return new AuthResponse(Base64.getEncoder().encodeToString(input.getBytes()),
                                     authRequest.getUsername(),
                                     user.getAuthorities().toString());
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }
}

