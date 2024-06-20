package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.model.CustomUserDetails;
import com.virtusa.project.PgRental.service.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
public ResponseEntity<Map<String, String>> login(@RequestBody UserDTO userDTO) {
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    userDTO.getUserName(),
                    userDTO.getPassword()
            )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);

    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    String role = userDetails.getAuthorities().stream()
                             .findFirst()
                             .map(GrantedAuthority::getAuthority)
                             .orElse("ROLE_USER");

    Map<String, String> response = new HashMap<>();
    response.put("message", "User logged in successfully");
    response.put("role", role);

    return ResponseEntity.ok(response);
}


    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("User logged out successfully");
    }

}
