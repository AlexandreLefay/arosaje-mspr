package fr.epsi.mspr.arosaje.entity.dto.login;

import lombok.Getter;

@Getter
public class LoginResponse {
    private final String jwt;

    public LoginResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}