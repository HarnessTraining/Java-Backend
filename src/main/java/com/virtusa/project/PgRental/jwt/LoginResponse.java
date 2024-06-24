package com.virtusa.project.PgRental.jwt;

import lombok.Data;

@Data
public class LoginResponse {
    private String jwtToken;

    private String username;
    private String roles;

    public LoginResponse(String jwtToken, String username, String roles) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
    }
}
