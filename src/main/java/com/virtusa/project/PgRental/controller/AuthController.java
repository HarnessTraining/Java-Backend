package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.jwt.JwtUtils;
import com.virtusa.project.PgRental.jwt.LoginResponse;
import com.virtusa.project.PgRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000") // Allow only your frontend origin
public class AuthController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return ResponseEntity.ok("User logged in successfully");
//    }

//    @PostMapping("/login")
//    @CrossOrigin("http://127.0.0.1:5500")
//    public ResponseEntity<Map<String, String>> login(@RequestBody UserDTO userDTO) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String role = userDetails.getAuthorities().stream().findFirst().map(authority -> authority.getAuthority()).orElse("ROLE_USER");
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "User logged in successfully");
//        response.put("role", role);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("User logged out successfully");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userDTO){
        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword()));
        }catch (AuthenticationException e){
            Map<String,Object> map = new HashMap<>();
            map.put("message","Bad credentials");
            map.put("status",false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDTO userDTO2 = userService.getUserByUserName(userDetails.getUsername());

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails,userDTO2.getUserId());

        String roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        
        System.out.println(userDTO2);
        
        LoginResponse response = new LoginResponse(jwtToken,userDetails.getUsername(),roles,userDTO2.getUserId());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate")
    public ResponseEntity<Map<String, Boolean>> validateToken(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        boolean isValid = jwtUtils.validateJwtToken(token); // Implement your token validation logic
        Map<String, Boolean> response = new HashMap<>();
        response.put("isValid", isValid);
        return ResponseEntity.ok(response);
    }

}
