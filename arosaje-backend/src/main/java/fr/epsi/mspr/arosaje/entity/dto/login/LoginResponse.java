package fr.epsi.mspr.arosaje.entity.dto.login;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Set;

@Getter
@Setter
public class LoginResponse {
    private String username;
    private int userId;
    private Set<String> roles;

    public LoginResponse(String username, int userId, String roles) {
        this.username = username;
        this.userId = userId;
        this.roles = Collections.singleton(roles);
    }


}