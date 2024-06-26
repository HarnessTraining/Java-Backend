package com.virtusa.project.PgRental.jwt;

import lombok.Data;

@Data
public class LoginResponse {
    private String jwtToken;
    private long id;
    private String username;
    private String roles;

    public LoginResponse(String jwtToken, String username, String roles,long id) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
        this.id = id;
    }
}
