package fr.epsi.mspr.arosaje.entity.dto.login;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class LoginResponse {
    private String username;
    private Set<String> roles;

    public LoginResponse(String username, String roles) {
        this.username = username;
        this.roles = Collections.singleton(roles);
    }


}