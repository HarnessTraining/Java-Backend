package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUserName(),
                        userDTO.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("User logged in successfully");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("User logged out successfully");
    }

}
